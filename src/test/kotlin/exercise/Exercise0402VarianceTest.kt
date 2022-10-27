package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.pow

class Exercise0402VarianceTest {

    @Test
    fun `variance 0`() {
        val result = variance(listOf(1.0, 1.0, 1.0))
        assertThat(result).isEqualTo(Some(0.0))
    }

    @Test
    fun variance() {
        val variance = variance(listOf(1.2, 4.5, 6.7, 2.3))
        assertThat(variance).isEqualTo(Some(4.461875))
    }

    private fun variance(xs: kotlin.collections.List<Double>): Option<Double> {
        return mean(xs).flatMap { m ->
            mean(xs.map {x ->
                (x - m).pow(2)
            })
        }
    }

    private fun mean(xs: kotlin.collections.List<Double>) =
        if(xs.isEmpty()) None
        else Some(xs.sum() / xs.size)
}


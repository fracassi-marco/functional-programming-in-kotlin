package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.pow

class Exercise0403Map2Test {

    @Test
    fun `either option is None`() {
        val result = map2<Int, Double, String>(Some(2), None) {_, _ -> "hello"}
        assertThat(result).isEqualTo(None)
    }

    @Test
    fun `both options are None`() {
        val result = map2<Int, Double, String>(None, None) {_, _ -> "hello"}
        assertThat(result).isEqualTo(None)
    }

    @Test
    fun variance() {
        val result = map2(Some(1), Some(2.2)) { a, b -> (a + b.toInt()).toString()}
        assertThat(result).isEqualTo(Some("3"))
    }

    private fun <A, B, C> map2(a: Option<A>, b: Option<B>, f: (A, B) -> C): Option<C> {
        if(a == None || b == None)
            return None

        return Some(f((a as Some<A>).get, (b as Some<B>).get))
    }

    private fun mean(xs: kotlin.collections.List<Double>) =
        if(xs.isEmpty()) None
        else Some(xs.sum() / xs.size)
}


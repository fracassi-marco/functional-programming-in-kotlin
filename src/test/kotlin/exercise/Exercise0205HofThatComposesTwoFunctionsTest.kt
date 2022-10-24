package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0205HofThatComposesTwoFunctionsTest {
    @Test
    fun `from string to int, to int to long`() {
        val compose = compose({ b: Int -> b.toLong() }, { a: String -> a.toInt() })
        val result = compose("5")

        assertThat(result).isEqualTo(5L)
    }

    private fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
        return { a: A -> f(g(a)) }
    }
}
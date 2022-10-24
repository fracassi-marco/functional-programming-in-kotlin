package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0204UncurryTest {

    @Test
    fun `sum of parts`() {
        val curry = uncurry { a: String -> { b: Int -> a.toLong() + b.toLong()} }
        val result = curry.invoke("5", 3)

        assertThat(result).isEqualTo(8L)
    }

    private fun <A, B, C> uncurry(f: (A) -> (B) -> C): (A, B) -> C {
        return { a: A, b: B -> f.invoke(a).invoke(b) }
    }
}
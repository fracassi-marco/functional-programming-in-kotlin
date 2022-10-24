package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0203CurryingTest {

    @Test
    fun `sum of parts`() {
        val curry = curry { a: String, b: Int -> a.toLong() + b.toLong() }
        val result = curry.invoke("5").invoke(3)

        assertThat(result).isEqualTo(8L)
    }

    private fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> (C) {
        return {a -> {b -> f.invoke(a, b)} }
    }
}
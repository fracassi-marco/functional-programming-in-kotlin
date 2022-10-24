package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0308LengthTest {
    @Test
    fun `compute length using foldRight`() {
        assertThat(List.of("A", "B", "C").length()).isEqualTo(3)
    }

    @Test
    fun `Nil has length 0`() {
        assertThat(Nil.length()).isEqualTo(0)
    }

    private fun <A> List<A>.length(): Int {
        return foldRight(0) { a: A, b: Int ->
            when (a) {
                is Nil -> 0
                else -> b + 1
            }
        }
    }
}


package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0317MapTest {

    @Test
    fun `double to string`() {
        val list = List.of(1.0, 2.0, 3.0)
        assertThat(list.map { it.toString() }).isEqualTo(List.of("1.0", "2.0", "3.0"))
    }

    private fun <A, B> List<A>.map(f: (A) -> B): List<B> {
        return when (this) {
            is Nil -> Nil
            is Cons -> Cons(f(head), tail.map(f))
        }
    }
}


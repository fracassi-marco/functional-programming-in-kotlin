package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0318FilterTest {

    @Test
    fun `double to string`() {
        val list = List.of(1, 5, 9, 1, 3)
        assertThat(list.filter { it > 2 }).isEqualTo(List.of(5, 9, 3))
    }

    private fun <A> List<A>.filter(f: (A) -> Boolean): List<A> {
        return when (this) {
            is Nil -> Nil
            is Cons -> if(f(head)) Cons(head, tail.filter(f)) else tail.filter(f)
        }
    }
}


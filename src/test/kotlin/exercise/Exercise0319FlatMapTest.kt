package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0319FlatMapTest {

    @Test
    fun `map to string`() {
        val list = List.of(1, 2, 3)
        assertThat(list.flatMap { List.of(it, it) }).isEqualTo(List.of(1, 1, 2, 2, 3, 3))
    }

    private fun <A> List<A>.flatMap(f: (A) -> List<A>): List<A> {
        return when (this) {
            is Nil -> Nil
            is Cons -> Cons(head, f(head).appendAll(tail.flatMap(f)))
        }
    }

    private fun <A> List<A>.appendAll(l: List<A>): List<A> {
        return when(this) {
            is Nil -> l
            is Cons -> when(tail) {
                is Nil -> l
                is Cons -> Cons(head, tail.appendAll(l))
            }
        }
    }
}


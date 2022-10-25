package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0322ZipWithTest {

    @Test
    fun `zip two list with the sum`() {
        val list = List.of(1, 2, 3)
        assertThat(list.zipWith(List.of(4, 5, 6)) { a, b -> a + b }).isEqualTo(List.of(5, 7, 9))
    }

    @Test
    fun `zip two list with the product`() {
        val list = List.of(1, 2, 3)
        assertThat(list.zipWith(List.of(4, 5, 6)) { a, b -> a * b }).isEqualTo(List.of(4, 10, 18))
    }

    @Test
    fun `first list is shorter than second one`() {
        val list = List.of(1, 2)
        assertThat(list.zipWith(List.of(4, 5, 6)) { a, b -> a + b }).isEqualTo(List.of(5, 7, 6))
    }

    @Test
    fun `second list is shorter than first one`() {
        val list = List.of(1, 2, 3)
        assertThat(list.zipWith(List.of(4, 5)) { a, b -> a + b }).isEqualTo(List.of(5, 7, 3))
    }

    private fun <A> List<A>.zipWith(l: List<A>, f: (A, A) -> A): List<A> {
        return when (this) {
            is Nil -> when (l) {
                is Nil -> Nil
                is Cons -> l
            }

            is Cons -> when (l) {
                is Nil -> this
                is Cons -> Cons(f(head, l.head), tail.zipWith(l.tail, f))
            }
        }
    }
}


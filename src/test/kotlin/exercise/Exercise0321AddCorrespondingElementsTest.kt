package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0321AddCorrespondingElementsTest {

    @Test
    fun `sum two list`() {
        val list = List.of(1, 2, 3)
        assertThat(list.adder(List.of(4, 5, 6))).isEqualTo(List.of(5, 7, 9))
    }

    @Test
    fun `first list is shorter than second one`() {
        val list = List.of(1, 2)
        assertThat(list.adder(List.of(4, 5, 6))).isEqualTo(List.of(5, 7, 6))
    }

    @Test
    fun `second list is shorter than first one`() {
        val list = List.of(1, 2, 3)
        assertThat(list.adder(List.of(4, 5))).isEqualTo(List.of(5, 7, 3))
    }

    private fun List<Int>.adder(l: List<Int>): List<Int> {
        return when (this) {
            is Nil -> when (l) {
                is Nil -> Nil
                is Cons -> l
            }

            is Cons -> when (l) {
                is Nil -> this
                is Cons -> Cons(head + l.head, tail.adder(l.tail))
            }
        }
    }
}


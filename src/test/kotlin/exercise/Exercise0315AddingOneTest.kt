package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0315AddingOneTest {

    @Test
    fun `add one to each element`() {
        val list = List.of(1, 2, 3)
        assertThat(addOne(list)).isEqualTo(List.of(2, 3, 4))
    }

    @Test
    fun `add one to Nil`() {
        assertThat(addOne(Nil)).isEqualTo(Nil)
    }

    private fun addOne(list: List<Int>): List<Int> {
        return when (list) {
            is Nil -> Nil
            is Cons -> Cons(list.head + 1, addOne(list.tail))
        }
    }
}


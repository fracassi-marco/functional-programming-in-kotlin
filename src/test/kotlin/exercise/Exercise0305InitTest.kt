package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0305InitTest {
    @Test
    fun `init new list without last element`() {
        val list = List.of("A", "B", "C")

        assertThat(list.init()).isEqualTo(List.of("A", "B"))
    }

    private fun <A> List<A>.init(): List<A> {
        return when (this) {
            is Cons -> when (tail) {
                is Nil -> Nil
                else -> Cons(head, tail.init())
            }

            is Nil -> Nil
        }
    }
}


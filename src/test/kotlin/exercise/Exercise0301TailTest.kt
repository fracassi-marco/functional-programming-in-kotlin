package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0301TailTest {
    @Test
    fun `remove the first element`() {
        val list = List.of("A", "B")
        assertThat(list.tail()).isEqualTo(List.of("B"))
    }

    private fun <A> List<A>.tail(): List<A> {
        return when(this) {
            is Cons -> tail
            is Nil -> Nil
        }
    }
}


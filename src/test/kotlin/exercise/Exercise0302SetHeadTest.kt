package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0302SetHeadTest {
    @Test
    fun `replace the first element`() {
        val list = List.of("B", "C")
        assertThat(list.setHead("A")).isEqualTo(List.of("A", "C"))
    }

    private fun <A> List<A>.setHead(element: A): List<A> {
        return when(this) {
            is Cons -> Cons(element, tail)
            is Nil -> Nil
        }
    }
}


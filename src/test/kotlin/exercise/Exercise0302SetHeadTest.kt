package exercise

import exercises.Cons
import exercises.Nil
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0302SetHeadTest {
    @Test
    fun `replace the first element`() {
        val list = Cons("B", Nil)
        assertThat(list.setHead("A")).isEqualTo(Cons("A", Nil))
    }

    private fun <A> exercises.List<A>.setHead(element: A): exercises.List<A> {
        return when(this) {
            is Cons -> Cons(element, this.tail)
            is Nil -> Nil
        }
    }
}


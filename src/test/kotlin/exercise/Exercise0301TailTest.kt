package exercise

import exercises.Cons
import exercises.Nil
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0301TailTest {
    @Test
    fun `remove the first element`() {
        val list = Cons("A", Cons("B", Nil))
        assertThat(list.tail()).isEqualTo(Cons("B", Nil))
    }

    fun <A> exercises.List<A>.tail(): exercises.List<A> {
        return when(this) {
            is Cons -> this.tail
            is Nil -> Nil
        }
    }
}


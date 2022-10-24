package exercise

import exercises.Cons
import exercises.Nil
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0303DropTest {
    @Test
    fun `drop first n elements`() {
        val list = Cons("A", Cons("B", Cons("C", Nil)))

        assertThat(list.drop(0)).isEqualTo(Cons("A", Cons("B", Cons("C", Nil))))
        assertThat(list.drop(1)).isEqualTo(Cons("B", Cons("C", Nil)))
        assertThat(list.drop(2)).isEqualTo(Cons("C", Nil))
        assertThat(list.drop(3)).isEqualTo(Nil)
    }

    private fun <A> exercises.List<A>.drop(n: Int): exercises.List<A> {
        tailrec fun go(i: Int, list: exercises.List<A>): exercises.List<A> {
            return when (list) {
                is Cons -> when (i) {
                    0 -> list
                    else -> go(i - 1, list.tail)
                }

                is Nil -> Nil
            }
        }
        return go(n, this)
    }
}


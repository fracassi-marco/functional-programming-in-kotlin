package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0303DropTest {
    @Test
    fun `drop first n elements`() {
        val list = List.of("A", "B", "C")

        assertThat(list.drop(0)).isEqualTo(List.of("A", "B", "C"))
        assertThat(list.drop(1)).isEqualTo(List.of("B", "C"))
        assertThat(list.drop(2)).isEqualTo(List.of("C"))
        assertThat(list.drop(3)).isEqualTo(Nil)
    }

    private fun <A> List<A>.drop(n: Int): List<A> {
        tailrec fun go(i: Int, list: List<A>): List<A> {
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


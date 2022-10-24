package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0304DropWhileTest {
    @Test
    fun `drop elements while condition match`() {
        val list = List.of("A", "B", "C")

        assertThat(list.dropWhile { it == "A" }).isEqualTo(List.of("B", "C"))
        assertThat(list.dropWhile { it == "B" }).isEqualTo(List.of("A", "B", "C"))
    }

    private fun <A> List<A>.dropWhile(f: (A) -> Boolean): List<A> {
        return when (this) {
            is Cons -> when (f(head)) {
                true -> tail.dropWhile(f)
                else -> this
            }

            is Nil -> Nil
        }
    }
}


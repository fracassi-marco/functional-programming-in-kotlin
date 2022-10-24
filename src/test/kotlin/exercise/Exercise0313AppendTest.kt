package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0313AppendTest {

    @Test
    fun `append using fold`() {
        val list = List.of("3", "4")
        assertThat(list.append("5")).isEqualTo(List.of("3", "4", "5"))
    }

    @Test
    fun `append to Nil`() {
        assertThat(empty<String>().append("A")).isEqualTo(List.of("A"))
    }

    private fun <A> List<A>.append(element: A): List<A> {
        return this.foldRight(List.of(element)) { a: A, b -> Cons(a, b) }
    }
}


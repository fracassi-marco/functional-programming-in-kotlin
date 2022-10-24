package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0311ReverseTest {

    @Test
    fun `reverse using fold`() {
        val list = List.of("3", "4", "5")
        assertThat(list.reverse()).isEqualTo(List.of("5", "4", "3"))
    }

    @Test
    fun `reverse of Nil is Nil`() {
        val list = Nil
        assertThat(list.reverse()).isEqualTo(Nil)
    }

    private fun <A> List<A>.reverse(): List<A> {
        return this.foldLeft(empty()) { a: A, b -> Cons(a, b) }
    }
}


package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0316DoubleToStringTest {

    @Test
    fun `double to string`() {
        val list = List.of(1.0, 2.0, 3.0)
        assertThat(toString(list)).isEqualTo(List.of("1.0", "2.0", "3.0"))
    }

    private fun toString(list: List<Double>): List<String> {
        return when (list) {
            is Nil -> Nil
            is Cons -> Cons(list.head.toString(), toString(list.tail))
        }
    }
}


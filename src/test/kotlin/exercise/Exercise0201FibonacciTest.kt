package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class Exercise0201FibonacciTest {

    @Test
    fun `sum of the previous two numbers`() {
        assertThat(fib(0)).isEqualTo(0)
        assertThat(fib(1)).isEqualTo(1)
        assertThat(fib(2)).isEqualTo(1)
        assertThat(fib(3)).isEqualTo(2)
        assertThat(fib(4)).isEqualTo(3)
        assertThat(fib(5)).isEqualTo(5)
    }

    private fun fib(i: Int): Int {
        tailrec fun go(state: Int, prev1: Int, prev2: Int): Int {
            if (state == 0) return prev1
            return go(state - 1, prev2, prev1 + prev2)
        }

        return go(i, 0, 1)
    }
}
package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0320FlatMapAsFilterTest {

    @Test
    fun `implement filter with flatMap`() {
        val list = List.of(1, 2, 3)
        assertThat(list.filter { it >= 2 }).isEqualTo(List.of(2, 3))
    }

    private fun <A> List<A>.filter(f: (A) -> Boolean): List<A> {
        return flatMap { if(f(it)) List.of(it) else Nil }
    }
}


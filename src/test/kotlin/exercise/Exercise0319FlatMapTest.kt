package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0319FlatMapTest {

    @Test
    fun `map to string`() {
        val list = List.of(1, 2, 3)
        assertThat(list.flatMap { it: Int -> List.of(it, it) }).isEqualTo(List.of(1, 1, 2, 2, 3, 3))
    }
}


package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0310FoldLeftOperationsTest {

    @Test
    fun `implement sum with foldLeft`() {
        val list = List.of(3, 4, 5)
        assertThat(list.foldLeft(0) { a: Int, b -> a + b }).isEqualTo(12)
    }

    @Test
    fun `implement product with foldLeft`() {
        val list = List.of(1, 4, 5)
        assertThat(list.foldLeft(1) { a: Int, b -> a * b }).isEqualTo(20)
    }

    @Test
    fun `implement length with foldLeft`() {
        val list = List.of(3, 4, 5, 6)
        assertThat(list.foldLeft(0) { a: Int, b -> b + 1 }).isEqualTo(4)
    }
}


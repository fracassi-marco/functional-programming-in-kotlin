package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0309FoldLeftTest {
    @Test
    fun `implement foldLeft as foldRight but with tail-recursion`() {
        val list = List.of("3", "4", "5")
        assertThat(list.foldRight(2) { a: String, b -> a.toInt() + b }).isEqualTo(14)
        assertThat(list.foldLeft(2) { a: String, b -> a.toInt() + b }).isEqualTo(14)
    }

    @Test
    fun `implement product with foldLeft`() {
        val list = List.of(3, 4, 5)
        assertThat(list.foldLeft(1) { a: Int, b -> a * b }).isEqualTo(60)
    }
}


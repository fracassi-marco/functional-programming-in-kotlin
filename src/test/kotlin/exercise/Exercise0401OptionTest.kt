package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0401OptionTest {

    @Test
    fun `map option`() {
        val result = Some(5).map { it.toString() }
        assertThat(result).isEqualTo(Some("5"))
        assertThat(None.map { it.toString() }).isEqualTo(None)
    }

    @Test
    fun `flatMap option`() {
        val result = Some(5).flatMap { Some(it + 1) }
        assertThat(result).isEqualTo(Some(6))
        assertThat(None.flatMap { Some(2) }).isEqualTo(None)
    }

    @Test
    fun `get or else`() {
        assertThat(Some(5).getOrElse { 1 }).isEqualTo(5)
        assertThat(None.getOrElse { 1 }).isEqualTo(1)
    }

    @Test
    fun `or else`() {
        assertThat(Some(5).orElse { Some(1) }).isEqualTo(Some(5))
        assertThat(None.orElse { Some(1) }).isEqualTo(Some(1))
    }

    @Test
    fun filter() {
        assertThat(Some(5).filter { it > 3 }).isEqualTo(Some(5))
        assertThat(Some(5).filter { it < 3 }).isEqualTo(None)
    }
}


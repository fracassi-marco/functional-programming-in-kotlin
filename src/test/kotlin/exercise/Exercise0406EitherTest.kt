package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0406EitherTest {

    @Test
    fun `map right`() {
        val result = Right("2").map { it.toInt() }
        assertThat(result).isEqualTo(Right(2))
    }

    @Test
    fun `map left`() {
        val result = Left(5).map { "2" }
        assertThat(result).isEqualTo(Left(5))
    }

    @Test
    fun `flat map`() {
        val result = Right("2").flatMap { Right(it.toInt()) }
        assertThat(result).isEqualTo(Right(2))
    }

    @Test
    fun `or else`() {
        assertThat(Left("2").orElse { Right(4) }).isEqualTo(Right(4))
        assertThat(Right("2").orElse { Right(4) }).isEqualTo(Right("2"))
    }

    @Test
    fun map2() {
        val result = map2(
            Right(5.6),
            Right(2)
        ) { a: Double, b: Int -> "hello ${a.toInt() + b}" }
        assertThat(result).isEqualTo(Right("hello 7"))
    }

    private fun <E, A, B, C> map2(ae: Either<E, A>, be: Either<E, B>, f: (A, B) -> C): Either<E, C> {
        return ae.flatMap { a -> be.map { b -> f(a, b) } }
    }
}


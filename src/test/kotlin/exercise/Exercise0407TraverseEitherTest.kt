package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0407TraverseEitherTest {

    @Test
    fun `traverse either`() {
        val result = traverse(List.of(1, 2, 3)) { Right(it.toString())}

        assertThat(result).isEqualTo(Right(List.of("1", "2", "3")))
    }

    @Test
    fun `sequence either`() {
        val result = sequence(List.of(Right(1), Right(2), Right(3)))

        assertThat(result).isEqualTo(Right(List.of(1, 2, 3)))
    }

    private fun <E, A, B> traverse(xs: List<A>, f: (A) -> Either<E, B>): Either<E, List<B>> {
        return when(xs) {
            is Nil -> Right(Nil)
            is Cons -> {
                Exercise0406EitherTest().map2(f(xs.head), traverse(xs.tail, f)) {b, xb -> Cons(b, xb)}
            }
        }
    }

    private fun <E, A> sequence(es: List<Either<E, A>>): Either<E, List<A>>  = traverse(es) { it }
}


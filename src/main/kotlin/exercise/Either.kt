package exercise

sealed class Either<out E, out A>
data class Left<out E>(val value: E) : Either<E, Nothing>()
data class Right<out A>(val value: A) : Either<Nothing, A>()

fun <E, A, B> Either<E, A>.map(f: (A) -> B): Either<E, B> {
    return when(this) {
        is Left -> this
        is Right -> Right(f(value))
    }
}

fun <E, A, B> Either<E, A>.flatMap(f: (A) -> Either<E, B>): Either<E, B> {
    return when(this) {
        is Left -> this
        is Right -> f(value)
    }
}

fun <E, A> Either<E, A>.orElse(f: () -> Either<E, A>): Either<E, A> {
    return when(this) {
        is Left -> f()
        is Right -> this
    }
}
package exercise

sealed class Option<out A>
data class Some<out A>(val get: A): Option<A>()
object None: Option<Nothing>()

fun <A> Option<A>.filter(f: (A) -> Boolean): Option<A> {
    return when(this) {
        is None -> None
        is Some -> when(f(get)) {
            true  -> this
            false -> None
        }
    }
}

fun <A> Option<A>.getOrElse(default: () -> A): A {
    return when(this) {
        is None -> default()
        is Some -> get
    }
}

fun <A> Option<A>.orElse(default: () -> Option<A>): Option<A> {
    return when(this) {
        is None -> default()
        is Some -> this
    }
}

fun <A, B> Option<A>.map(f: (A) -> B): Option<B> {
    return when(this) {
        is None -> None
        is Some -> Some(f(get))
    }
}

fun <A, B> Option<A>.flatMap(f: (A) -> Option<B>): Option<B> {
    return when(this) {
        is None -> None
        is Some -> f(get)
    }
}
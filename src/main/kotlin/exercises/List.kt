package exercises

sealed class List<out A>
data class Cons<out A>(val head: A, val tail: List<A>): List<A>()
object Nil: List<Nothing>()
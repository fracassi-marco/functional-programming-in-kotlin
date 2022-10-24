package exercise

sealed class List<out A> {
    companion object {
        fun <A> of(vararg aa:A): List<A> {
            val tail = aa.sliceArray(1 until aa.size)
            return if(aa.isEmpty()) Nil else Cons(aa[0], of(*tail))
        }
    }
}
data class Cons<out A>(val head: A, val tail: List<A>): List<A>()
object Nil: List<Nothing>()
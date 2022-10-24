package exercise

sealed class List<out A> {
    companion object {
        fun <A> of(vararg aa: A): List<A> {
            val tail = aa.sliceArray(1 until aa.size)
            return if (aa.isEmpty()) Nil else Cons(aa[0], of(*tail))
        }

    }

    fun <A, B> foldRight(z: B, f: (A, B) -> B): B {
        return when (this) {
            is Nil -> z
            is Cons -> {
                val head = (this as Cons<A>).head
                f(head, tail.foldRight(z, f))
            }
        }
    }

    fun <A, B> foldLeft(z: B, f: (A, B) -> B): B {
        return when (this) {
            is Nil -> z
            is Cons -> {
                tail.foldLeft(f((this as Cons<A>).head, z), f)
            }
        }
    }
}

data class Cons<out A>(val head: A, val tail: List<A>) : List<A>()
object Nil : List<Nothing>()
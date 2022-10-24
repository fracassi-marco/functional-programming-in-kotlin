package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0202IsSortedTest {

    private val <T> kotlin.collections.List<T>.head: T
        get() = first()

    private val <T> kotlin.collections.List<T>.tail: kotlin.collections.List<T>
        get() = drop(1)

    @Test
    fun `list of string sorted by int representation - implementation 1`() {
        assertThat(isSorted(listOf("1", "2", "3")) { a1, a2 -> a1.toInt() < a2.toInt() }).isTrue
        assertThat(isSorted(listOf("3", "1", "2")) { a1, a2 -> a1.toInt() < a2.toInt() }).isFalse
    }

    @Test
    fun `list of string sorted by int representation - implementation 2`() {
        assertThat(isSorted2(listOf("1", "2", "3")) { a1, a2 -> a1.toInt() < a2.toInt() }).isTrue
        assertThat(isSorted2(listOf("3", "1", "2")) { a1, a2 -> a1.toInt() < a2.toInt() }).isFalse
    }

    @Test
    fun `list of int sorted by length - implementation 1`() {
        assertThat(isSorted(listOf(111, 11, 1)) { a1, a2 -> a1.toString().length > a2.toString().length }).isTrue
        assertThat(isSorted(listOf(1, 111, 11)) { a1, a2 -> a1.toString().length > a2.toString().length }).isFalse
    }

    @Test
    fun `list of int sorted by length - implementation 2`() {
        assertThat(isSorted2(listOf(111, 11, 1)) { a1, a2 -> a1.toString().length > a2.toString().length }).isTrue
        assertThat(isSorted2(listOf(1, 111, 11)) { a1, a2 -> a1.toString().length > a2.toString().length }).isFalse
    }

    private fun <A> isSorted(aa: kotlin.collections.List<A>, order: (A, A) -> Boolean): Boolean {
        tailrec fun go(list: kotlin.collections.List<A>): Boolean {
            if (list.size < 2) return true
            if (order.invoke(list.head, list.tail.head)) return go(list.tail)
            return false
        }
        return go(aa)
    }

    private fun <A> isSorted2(aa: kotlin.collections.List<A>, order: (A, A) -> Boolean): Boolean {
        tailrec fun go(previousItem: A, list: kotlin.collections.List<A>): Boolean {
            if (list.isEmpty()) return true
            if (order.invoke(previousItem, list.head)) return go(list.head, list.tail)
            return false
        }
        return go(aa.first(), aa.tail)
    }
}
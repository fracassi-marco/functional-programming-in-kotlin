package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0323HasSubsequenceTest {

    @Test
    fun `has subsequence`() {
        val list = List.of(1, 2, 3, 4)
        assertThat(list.hasSubsequence(List.of(1, 2))).isTrue
        assertThat(list.hasSubsequence(List.of(2, 3))).isTrue
        assertThat(list.hasSubsequence(List.of(4))).isTrue
        assertThat(list.hasSubsequence(List.of(1, 2, 3, 4))).isTrue
    }

    @Test
    fun `has not subsequence`() {
        val list = List.of(1, 2, 3, 4)
        assertThat(list.hasSubsequence(List.of(3, 2))).isFalse
        assertThat(list.hasSubsequence(List.of(4, 5))).isFalse
    }

    private tailrec fun <A> List<A>.hasSubsequence(sub: List<A>): Boolean {
        return when (this) {
            is Nil -> when (sub) {
                is Nil -> true
                is Cons -> false
            }

            is Cons -> when (sub) {
                is Nil -> true
                is Cons -> tail.hasSubsequence(if(head == sub.head) sub.tail else sub)
            }
        }
    }
}


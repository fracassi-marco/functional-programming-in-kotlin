package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0328FoldTest {

    @Test
    fun `size with fold`() {
        val tree = Branch(
            Leaf(1),
            Branch(
                Leaf(2),
                Leaf(3)
            )
        )
        assertThat(tree.size()).isEqualTo(5)
    }

    private fun <A> Tree<A>.size(): Int {
        return fold({ 1 }, { l: Int, r: Int -> 1 + l + r })
    }

    @Test
    fun `max with fold`() {
        val tree = Branch(
            Leaf(9),
            Branch(
                Leaf(2),
                Leaf(3)
            )
        )
        assertThat(tree.max()).isEqualTo(9)
    }

    private fun Tree<Int>.max(): Int {
        return fold({ l -> l }, { l: Int, r: Int -> maxOf(l, r) })
    }

    @Test
    fun `depth with fold`() {
        val tree = Branch(
            Leaf(9),
            Branch(
                Leaf(2),
                Leaf(7)
            )
        )
        assertThat(tree.depth()).isEqualTo(2)
    }

    private fun Tree<Int>.depth(): Int {
        return fold({ 0 }, { l, r -> 1 + maxOf(l, r) })
    }

    @Test
    fun `map with fold`() {
        val tree = Branch(
            Leaf(9),
            Branch(
                Leaf(2),
                Leaf(7)
            )
        )
        val expected = Branch(
            Leaf(10),
            Branch(
                Leaf(3),
                Leaf(8)
            )
        )
        assertThat(tree.map { it + 1 }).isEqualTo(expected)
    }

    private fun <A, B> Tree<A>.fold(l: (A) -> B, b: (B, B) -> B): B {
        return when (this) {
            is Leaf -> l(value)
            is Branch -> b(left.fold(l, b), right.fold(l, b))
        }
    }

    private fun <A, B> Tree<A>.map(f: (A) -> B): Tree<B> {
        return fold({ a -> Leaf(f(a)) }, { l: Tree<B>, r: Tree<B> -> Branch(l, r) })
    }
}


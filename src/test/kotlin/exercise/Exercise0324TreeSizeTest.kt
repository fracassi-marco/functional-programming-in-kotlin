package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0324TreeSizeTest {

    @Test
    fun `single node`() {
        val tree = Leaf(1)
        assertThat(tree.size()).isEqualTo(1)
    }

    @Test
    fun `multiple nodes`() {
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
        fun go(tree: Tree<A>, count: Int): Int {
            return when(tree) {
                is Leaf -> count + 1
                is Branch -> count + 1 + tree.left.size() + tree.right.size()
            }
        }
        return go(this, 0)
    }
}


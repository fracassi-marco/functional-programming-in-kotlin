package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0325MaxTest {

    @Test
    fun `single node`() {
        val tree = Leaf(1)
        assertThat(tree.max()).isEqualTo(1)
    }

    @Test
    fun `multiple nodes`() {
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
        fun go(tree: Tree<Int>, max: Int): Int {
            return when(tree) {
                is Leaf -> maxOf(tree.value, max)
                is Branch -> maxOf(go(tree.left, max), go(tree.right, max))
            }
        }
        return go(this, Int.MIN_VALUE)
    }
}


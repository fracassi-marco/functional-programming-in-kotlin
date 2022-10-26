package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0326DepthTest {

    @Test
    fun `single node`() {
        val tree = Leaf(4)
        assertThat(tree.depth()).isEqualTo(1)
    }

    @Test
    fun `multiple nodes`() {
        val tree = Branch(
            Leaf(9),
            Branch(
                Leaf(2),
                Leaf(7)
            )
        )
        assertThat(tree.depth()).isEqualTo(3)
    }

    private fun Tree<Int>.depth(): Int {
        return when (this) {
            is Leaf -> 1
            is Branch -> 1 + maxOf(left.depth(), right.depth())
        }
    }
}


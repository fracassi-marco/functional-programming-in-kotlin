package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0327MapTreeTest {

    @Test
    fun `single node`() {
        val tree = Leaf(4)
        assertThat(tree.map { it.toString() }).isEqualTo(Leaf("4"))
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
        val expected = Branch(
            Leaf(10),
            Branch(
                Leaf(3),
                Leaf(8)
            )
        )
        assertThat(tree.map { it + 1 }).isEqualTo(expected)
    }

    private fun <A, B> Tree<A>.map(f: (A) -> B): Tree<B> {
        return when (this) {
            is Leaf -> Leaf(f(value))
            is Branch -> Branch(left.map(f), right.map(f))
        }
    }
}


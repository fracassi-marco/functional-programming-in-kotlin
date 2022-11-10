package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0405TraverseTest {

    @Test
    fun `contains None even once`() {
        val result = traverse(listOf(2, 3)) { if(it == 2) None else Some(it.toString()) }
        assertThat(result).isEqualTo(None)
    }

    @Test
    fun `traverse all elements`() {
        val result = traverse(listOf(2, 3)) { Some(it.toString()) }
        assertThat(result).isEqualTo(Some(listOf("2", "3")))
    }

    private fun <A, B> traverse(xs: kotlin.collections.List<A>, f: (A) -> Option<B>): Option<kotlin.collections.List<B>> {
        val result = mutableListOf<B>()

        xs.forEach { each ->
            when(val optionB = f(each)) {
                is None -> return None
                is Some -> result.add(optionB.get)
            }
        }

        return Some(result.toList())
    }
}


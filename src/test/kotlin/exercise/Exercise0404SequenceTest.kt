package exercise

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Exercise0404SequenceTest {

    @Test
    fun `contains None even once`() {
        val result = sequence(listOf(Some(2), None))
        assertThat(result).isEqualTo(None)
    }

    @Test
    fun `sequence list`() {
        val result = sequence(listOf(Some(2), Some(3)))
        assertThat(result).isEqualTo(Some(listOf(2, 3)))
    }

    private fun <A> sequence(xs: kotlin.collections.List<Option<A>>): Option<kotlin.collections.List<A>> {
        if(xs.any { it == None })
            return None
        return Some(xs.map { (it as Some).get })
    }
}


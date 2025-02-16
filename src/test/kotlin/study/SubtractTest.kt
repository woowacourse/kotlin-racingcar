package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SubtractTest {
    @Test
    fun `Double 리스트에 Int리스트를 뺄 경우 제외되는지 테스트`() {
        val doubleList = listOf(1.0, 2.0, 3.0, 4.0)
        val intList = listOf(1, 2, 3, 4)
        val actual = emptySet<Int>()
        assertThat(actual).isNotEqualTo(doubleList.subtract(intList))
    }

    @Test
    fun `Double 리스트에 float리스트를 변환 후 뺄 경우 제외되는지 테스트`() {
        val doubleList = listOf(1.0, 2.0, 3.0, 4.0)
        val flotList = listOf(1.0F, 2.0f, 3.0f, 4.0f).toSet()
        val actual = emptyList<Double>()
        assertThat(actual).isNotEqualTo(doubleList.subtract(flotList))
    }
}

package car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PositionTest {
    @Test
    fun `생성시 0으로 초기화 되는지 여부 테스트`() {
        val position = Position()
        assertThat(position.position).isEqualTo(0)
    }

    @Test
    fun `goForward 정상 동작 여부 테스트`() {
        val position = Position()
        position.goForward()
        position.goForward()
        assertThat(position.position).isEqualTo(2)
    }

    @Test
    fun `data class가 자동으로 생성해주는 EqualsTo 테스트`() {
        val position = Position()
        val position2 = Position()
        assertThat(position).isEqualTo(position2)
    }
}
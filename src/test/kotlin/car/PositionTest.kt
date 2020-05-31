package car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PositionTest {
    @Test
    fun `생성시 0으로 초기화 한다`() {
        val position = Position()
        assertThat(position.position).isEqualTo(0)
    }

    @Test
    fun `goForward 실행시 position이 이동한다`() {
        val position = Position()
        position.goForward()
        position.goForward()
        assertThat(position.position).isEqualTo(2)
    }

    @Test
    fun `값 객체로서 동등성을 확인한다`() {
        val position = Position()
        val position2 = Position()
        assertThat(position).isEqualTo(position2)
    }
}
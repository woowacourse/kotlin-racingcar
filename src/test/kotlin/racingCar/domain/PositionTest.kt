package racingCar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class PositionTest {

    @Test
    @DisplayName("true일 때, 전진한다")
    fun trueIsGo() {
        val position = Position(0)
        position.move { true }
        assertThat(position.index).isEqualTo(1)
    }

    @Test
    @DisplayName("false일 때, 전진하지 않는다")
    fun falseIsNotGo() {
        val position = Position(0)
        position.move { false }
        assertThat(position.index).isEqualTo(0)
    }
}

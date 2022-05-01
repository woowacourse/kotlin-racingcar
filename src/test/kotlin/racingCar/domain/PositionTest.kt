package racingCar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingCar.domain.move.MoveStrategy

internal class PositionTest{

    @Test
    @DisplayName("true일 때, 전진한다")
    fun trueIsGo(){
        val position = Position(0)
        position.move(object : MoveStrategy {
            override fun isMovable(): Boolean {
                return true
            }
        });
        assertThat(position.index).isEqualTo(1)
    }

    @Test
    @DisplayName("false일 때, 전진하지 않는다")
    fun falseIsNotGo(){
        val position = Position(0)
        position.move(object : MoveStrategy {
            override fun isMovable(): Boolean {
                return false
            }
        });
        assertThat(position.index).isEqualTo(0)
    }
}
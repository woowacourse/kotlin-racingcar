package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    internal fun move() {
        val moveStrategy:MoveStrategy = object:MoveStrategy{
            override fun isMovable(): Boolean {
                return true
            }

        }
        val car = Car(moveStrategy)
        car.move()
        assertThat(car.isSamePosition(1)).isTrue()
    }
}
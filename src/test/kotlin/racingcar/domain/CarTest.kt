package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    internal fun move() {
        val car = Car()
        val moveStrategy:MoveStrategy = object:MoveStrategy{
            override fun isMovable(): Boolean {
                return true
            }

        }
        car.move(moveStrategy)
        assertThat(car.position).isEqualTo(1)
    }
}
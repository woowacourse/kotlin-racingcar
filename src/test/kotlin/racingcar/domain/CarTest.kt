package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun isSamePosition() {
        val name = "pobi"
        val position = 0
        val car = Car(name, position)

        assertThat(car.isSamePosition(Position(0))).isTrue
    }

    @Test
    fun moveForward() {
        val name = "pobi"
        val position = 0
        val car = Car(name, position)
        val strategy = RandomMovingStrategy((0..9), 0)

        val movedCar = car.moveForward(strategy)

        assertThat(movedCar.isSamePosition(Position(1))).isTrue
    }
}

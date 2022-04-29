package racingcar.domain

import org.assertj.core.api.Assertions.*

import org.junit.jupiter.api.DisplayName
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

        car.moveForward()

        assertThat(car.isSamePosition(Position(1))).isTrue
    }
}
package racingCar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import racingCar.model.Car

class CarTest {
    private lateinit var car: Car

    @Test
    @DisplayName("자동차가 생성되면, 위치는 0이어야 한다.")
    fun carInitialPositionTest() {
        val car = Car("test")
        assertThat(car.getPosition()).isEqualTo(Car.INIT_POSITION)
    }

    @Test
    @DisplayName("자동차의 이름은 존재해야 한다.")
    fun carNameNullTest() {
        assertThrows<IllegalArgumentException> {
            val car = Car("")
        }
    }

    @Test
    @DisplayName("자동차의 이름은 5자 이하여야 한다.")
    fun carNameLengthLessThenFive() {
        assertDoesNotThrow {
            val car = Car("pobib")
        }
    }

    @Test
    @DisplayName("자동차 이름이 6자 이상이면 예외를 발생한다.")
    fun carNameExceptionTest() {
        assertThrows<IllegalArgumentException> {
            val car = Car("오이오이오이")
        }
    }

    @Test
    @DisplayName("자동차는 전진한다.")
    fun carMovedForwardTest() {
        car = Car("test")
        car.moveForward()
        assertEquals(car.getPosition(), Car.INIT_POSITION + 1)
    }
}

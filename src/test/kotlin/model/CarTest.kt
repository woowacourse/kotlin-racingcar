package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    @DisplayName("자동차가 생성되면, 위치는 0이어야 한다.")
    fun carInitialPositionTest() {
        val car = Car("test")
        assertThat(car.position).isEqualTo(Car.INIT_POSITION)
    }

    @Test
    @DisplayName("자동차의 이름은 존재해야 한다.")
    fun carNameNullTest() {
        val exception =
            assertThrows<IllegalArgumentException> {
                Car("")
            }
        assertEquals("자동차 이름에 빈 값이 입력되었습니다.", exception.message)
    }

    @Test
    @DisplayName("자동차의 이름은 5자 이하여야 한다.")
    fun carNameLengthLessThenFive() {
        assertDoesNotThrow {
            Car("pobib")
        }
    }

    @Test
    @DisplayName("자동차 이름이 6자 이상이면 예외를 발생한다.")
    fun carNameExceptionTest() {
        val wrongCarName = "오이오이오이"
        val exception =
            assertThrows<IllegalArgumentException> {
                Car(wrongCarName)
            }
        assertEquals("자동차 이름이 5자를 초과하였습니다.: $wrongCarName", exception.message)
    }

    @Test
    @DisplayName("숫자가 4 이상이면 1칸 전진한다.")
    fun carMovedForwardTest() {
        val car = Car("test")
        car.moveForward(Car.MINIMUM_MOVE_POINT)
        assertEquals(car.position, Car.INIT_POSITION + 1)
    }

    @Test
    @DisplayName("숫자가 4 미만이면 전진하지 않는다")
    fun carDoNotMoveForwardTest() {
        val car = Car("test")
        car.moveForward(Car.MINIMUM_MOVE_POINT - 1)
        assertEquals(car.position, Car.INIT_POSITION)
    }
}

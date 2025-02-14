package racingCar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차의 초기 위치는 0이다`() {
        val car = Car("공백")
        val initialPosition = 0
        Assertions.assertEquals(initialPosition, car.position)
    }

    @Test
    fun `전진한 후 자동차는 이전 위치보다 앞서있다`() {
        val car = Car("뭉치")
        val isMoved = true
        val previousPosition = car.position

        car.moveForward(isMoved)

        Assertions.assertTrue(car.position > previousPosition)
    }

    @Test
    fun `전진이 불가능하면 자동차는 멈춘다`() {
        val car = Car("뭉치")
        val isMoved = false
        val previousPosition = car.position

        car.moveForward(isMoved)

        Assertions.assertTrue(car.position == previousPosition)
    }
}

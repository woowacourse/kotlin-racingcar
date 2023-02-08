package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RacingCarTest {

    private lateinit var car: RacingCar

    @BeforeEach
    fun init() {
        car = RacingCar("name")
    }

    @Test
    fun `전진했을 때 toString 변화 테스트`() {
        car.moveForward()
        car.moveForward()
        assertEquals(
            "name : --",
            car.toString(),
        )
    }

    @Test
    fun `전진 정도에 따른 객체 비교 테스트`() {
        val other = RacingCar("other")
        moveCar(other, 2)
        moveCar(car, 1)
        assertEquals(
            -1,
            car.compareTo(other),
        )
    }

    private fun moveCar(car: RacingCar, count: Int) {
        for (i in 0 until count) {
            car.moveForward()
        }
    }
}

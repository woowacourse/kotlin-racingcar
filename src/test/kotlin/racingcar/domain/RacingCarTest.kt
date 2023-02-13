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
}

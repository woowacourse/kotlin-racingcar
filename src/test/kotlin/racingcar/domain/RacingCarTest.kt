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
    fun `toString 정상적으로 작동하는지 확인 테스트(2번 전진)`() {
        car.moveForward()
        car.moveForward()
        assertEquals(
            "name : --",
            car.toString(),
        )
    }
}

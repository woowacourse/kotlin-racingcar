package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.constant.STATE_UNIT

class RacingCarTest {

    private lateinit var car: RacingCar

    @BeforeEach
    fun init() {
        car = RacingCar("name")
    }

    @ValueSource(ints = [1, 5, 7, 3])
    @ParameterizedTest
    fun `toString 출력 양식에 맞게 변환되는지 확인 `(input: Int) {
        for (moveCount in 1..input) {
            car.moveForward()
        }
        assertEquals(
            "name : ${STATE_UNIT.repeat(input)}",
            car.toString(),
        )
    }
}

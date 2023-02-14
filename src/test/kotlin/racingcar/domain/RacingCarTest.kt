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
    fun `toString 이동한 거리만큼 "-"의 반복으로 출력 `(input: Int) {
        for (moveCount in 1..input) {
            car.moveForward()
        }
        assertEquals(
            "name : ${STATE_UNIT.repeat(input)}",
            car.toString(),
        )
    }
}

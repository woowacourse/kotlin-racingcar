package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    lateinit var car: Car

    @BeforeEach
    fun beforeEach() {
        car = Car("otter")
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `자동차가 전진한 횟수 만큼 "-"가 표현됩니다`(moveCount: Int) {
        repeat(moveCount) {
            car.takeOneStepForward()
        }

        assertEquals(
            "-".repeat(moveCount),
            car.getPositionAsDash()
        )
    }
}

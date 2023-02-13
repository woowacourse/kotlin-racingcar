package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    private lateinit var car: Car
import org.junit.jupiter.api.Test

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
            car.move(true)
        }

        assertEquals(
            "-".repeat(moveCount),
            car.getPositionAsDash()
        )
    @Test
    fun `움직임 정상 테스트`() {
        val moveCount = 5

        repeat(moveCount) {
            car.move()
        }

        assertEquals("-".repeat(moveCount), car.getPositionAsDash())
    }
}

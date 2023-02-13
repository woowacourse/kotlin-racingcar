package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.domain.numbergenerator.StubNumberGenerator

class RacingGameTest {
    private val generator = StubNumberGenerator(mutableListOf(5, 3, 5))
    private val referee = Referee()
    private val racingGame = RacingGame(generator, referee)

    @Test
    fun `play 함수 2회 전진 1회 정지 경우의수 검증`() {
        val car = RacingCar("name")
        for (i in 0..2) {
            racingGame.play(car)
        }
        assertEquals(
            2,
            car.movingState,
        )
    }
}

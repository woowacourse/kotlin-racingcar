package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class RacingGameTest {
    private lateinit var racingGame: RacingGame
    private lateinit var carA: Car
    private lateinit var carB: Car

    @BeforeEach
    fun setup() {
        carA = Car("A")
        carB = Car("B")
        racingGame = RacingGame(mutableListOf(carA, carB))
    }

    @RepeatedTest(100)
    fun `랜덤넘버 리스트의 요소가 전부 제한 범위 내인지`() {
        val result = racingGame.generateRandomNumber()
        assertThat(result).isIn(0..9)
    }

    @Test
    fun `자동차가 실제로 이동하는지`() {
        racingGame.carMovingControl()
        assert(carA.position != "" || carB.position != "")
    }
}

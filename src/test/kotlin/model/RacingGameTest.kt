package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.NumberGenerator
import racingcar.model.RacingGame

class RacingGameTest {
    @Test
    fun `경주 종료 후 우승자 검증 테스트`() {
        val numbers = listOf(1, 6, 3)
        val generator = FixedNumberGenerator(numbers)
        val racingGame = RacingGame(generator)

        racingGame.generateCars(listOf("CarA", "CarB", "CarC"))

        val expected = "CarB"
        racingGame.tryRacing(1) {}
        val result = racingGame.calculateWinner()

        assertThat(result).contains(expected)
    }

    @Test
    fun `경주 종료 후 복수 우승자 검증 테스트`() {
        val numbers = listOf(1, 6, 6)
        val generator = FixedNumberGenerator(numbers)
        val racingGame = RacingGame(generator)

        racingGame.generateCars(listOf("CarA", "CarB", "CarC"))

        racingGame.tryRacing(1) {}
        val result = racingGame.calculateWinner()

        assertThat(result).contains("CarB, CarC")
    }

    inner class FixedNumberGenerator(
        private val numbers: List<Int>,
    ) : NumberGenerator {
        private var idx: Int = 0

        override fun generate(
            min: Int,
            max: Int,
        ): Int {
            return numbers[idx++]
        }
    }
}

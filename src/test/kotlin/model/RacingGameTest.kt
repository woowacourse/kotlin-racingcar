package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingGameTest {
    @ParameterizedTest
    @ValueSource(strings = ["", " ", "car12345", "1", "car, car", "car1, car12345"])
    fun `입력 값으로부터 자동차 이름 검증 예외 테스트`(input: String) {
        val generator = RandomNumberGeneratorImpl()
        val racingGame = RacingGame(generator)
        assertThrows<IllegalArgumentException> { racingGame.generateCars(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "0", "-1"])
    fun `입력 값으로부터 경주 실행 횟수 검증 예외 테스트`(input: String) {
        val generator = RandomNumberGeneratorImpl()
        val racingGame = RacingGame(generator)
        racingGame.generateCars("carA, carB")
        assertThrows<IllegalArgumentException> { racingGame.tryRacing(input) }
    }

    @Test
    fun `경주 종료후 우승자 검증 테스트`() {
        val numbers = listOf(1, 6, 3)
        val generator = TestNumberGenerator(numbers)
        val racingGame = RacingGame(generator)

        racingGame.generateCars("CarA, CarB, CarC")

        val expected = "CarB"
        racingGame.tryRacing("1")
        val result = racingGame.calculateWinner()

        assertThat(result).contains(expected)
    }

    @Test
    fun `경주 종료후 복수 우승자 검증 테스트`() {
        val numbers = listOf(1, 6, 6)
        val generator = TestNumberGenerator(numbers)
        val racingGame = RacingGame(generator)

        racingGame.generateCars("CarA, CarB, CarC")

        racingGame.tryRacing("1")
        val result = racingGame.calculateWinner()

        assertThat(result).contains("CarB, CarC")
    }

    inner class TestNumberGenerator(
        private val numbers: List<Int>,
    ) : RandomNumberGenerator {
        private var idx: Int = 0

        override fun generate(
            min: Int,
            max: Int,
        ): Int {
            return numbers[idx++]
        }
    }
}

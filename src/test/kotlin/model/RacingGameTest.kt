package model

import RacingGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingGameTest {
    @ParameterizedTest
    @ValueSource(strings = ["", " ", "car12345", "1", "car, car", "car1, car12345"])
    fun `입력 값으로부터 자동차 이름 검증 예외 테스트`(input: String) {
        val generateCar = CarFactory()
        assertThrows<IllegalArgumentException> { generateCar.createCars(input) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1])
    fun `입력 값으로부터 경주 실행 횟수 검증 예외 테스트`(input: Int) {
        val generator = RandomNumberGenerator()
        val generateCar = CarFactory().createCars("carA, carB")
        val racingGame = RacingGame(generator, generateCar)
        assertThrows<IllegalArgumentException> { racingGame.runRace(input) }
    }

    @Test
    fun `경주 종료후 우승자 검증 테스트`() {
        val numbers = listOf(1, 6, 3)
        val generator = TestNumberGenerator(numbers)
        val generateCar = CarFactory().createCars("carA, carB")
        val racingGame = RacingGame(generator, generateCar)

        val expected = "carB"
        racingGame.runRace(1)
        val result = racingGame.getWinners()

        assertThat(result).contains(expected)
    }

    @Test
    fun `경주 종료후 복수 우승자 검증 테스트`() {
        val numbers = listOf(1, 6, 6)
        val generator = TestNumberGenerator(numbers)
        val generateCar = CarFactory().createCars("carA, carB, carC")
        val racingGame = RacingGame(generator, generateCar)

        racingGame.runRace(1)
        val result = racingGame.getWinners()

        assertThat(result).contains("carB", "carC")
    }

    inner class TestNumberGenerator(
        private val numbers: List<Int>,
    ) : NumberGenerator {
        private var idx: Int = 0

        override fun generate(): Int {
            return numbers[idx++]
        }
    }
}

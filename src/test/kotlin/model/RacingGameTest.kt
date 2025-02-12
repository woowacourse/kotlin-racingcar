package model

import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.assertj.core.api.Assertions.assertThat

class RacingGameTest {
    private lateinit var racingGame: RacingGame

    @BeforeEach
    fun setup() {
        racingGame = RacingGame()
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "car12345", "1", "car1, car1", "car1, car12345"])
    fun `자동차 생성 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> { racingGame.generateCars(input) }
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `자동차 전진 테스트`(randomValue: Int) {
        val car = Car("carA")
        car.tryForward(randomValue)

        val output = car.getStep()
        val expected = "carA : -"

        assertThat(output).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `자동차 전진 실패 테스트`(randomValue: Int) {
        val car = Car("carA")
        car.tryForward(randomValue)

        val output = car.getStep()
        val expected = "carA : "

        assertThat(output).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "0", "-1"])
    fun `경주 횟수 입력 예외 테스트`(input: String) {
        racingGame.generateCars("carA, carB")
        assertThrows<IllegalArgumentException> { racingGame.tryRacing(input) }
    }

}

package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Name

internal class CarTest {

    private val testCar = Car(Name("test"))

    @DisplayName("이름이 빈칸이면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun validateNameBlank(name: String) {
        assertThrows<IllegalArgumentException> {
            Car(Name(name))
        }
    }

    @DisplayName("이름이 5글자 초과면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = ["123456", "abcdef"])
    fun validateTooLongName(name: String) {
        assertThrows<IllegalArgumentException> {
            Car(Name(name))
        }
    }

    @DisplayName("4이상의 값이 입력할 시 이동한다.")
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 10])
    fun tryToMoveWhenOverScore(point: Int) {
        val prePosition = testCar.position()
        testCar.tryToMove(point)

        assertThat(testCar.position()).isEqualTo(prePosition + 1)
    }

    @DisplayName("3이하의 값이 입력할 시 이동하지 못한다.")
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun tryToMoveWhenUnderScore(point: Int) {
        val prePosition = testCar.position()
        testCar.tryToMove(point)

        assertThat(testCar.position()).isEqualTo(prePosition)
    }
}
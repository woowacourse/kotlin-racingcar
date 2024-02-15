package racingcar

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.view.input.InputValidator

class ExceptionTest {
    private val inputValidator = InputValidator()

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = ["", " ", ",,,"])
    fun `자동차 이름을 입력하지 않는 경우 예외가 발생한다`(inputCarNames: String?) {
        assertThrows<IllegalArgumentException> {
            inputValidator.validateCarNames(inputCarNames)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["aaaaaa", "abcdefghig", "abcdefghig,abc"])
    fun `자동차 이름이 다섯 글자가 넘는 경우 예외가 발생한다`(inputCarNames: String) {
        assertThrows<IllegalArgumentException> {
            inputValidator.validateCarNames(inputCarNames)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["?", "olive, 채채", "olive1", "123"])
    fun `자동차 이름에 숫자, 특수문자 등이 포함되는 경우 예외가 발생한다`(inputCarNames: String) {
        assertThrows<IllegalArgumentException> {
            inputValidator.validateCarNames(inputCarNames)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["olive,olive", "olive,olive,aaa"])
    fun `자동차 이름이 중복되는 경우 예외가 발생한다`(inputCarNames: String) {
        assertThrows<IllegalArgumentException> {
            inputValidator.validateCarNames(inputCarNames)
        }
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = ["", " "])
    fun `시도할 횟수를 입력하지 않는 경우 예외가 발생한다`(inputTryCount: String?) {
        assertThrows<IllegalArgumentException> {
            inputValidator.validateTryCount(inputTryCount)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["?", "olive", "채채"])
    fun `시도할 횟수에 알파벳, 특수문자 등이 포함되는 경우 예외가 발생한다`(inputTryCount: String) {
        assertThrows<IllegalArgumentException> {
            inputValidator.validateTryCount(inputTryCount)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "1001", "210000"])
    fun `시도할 횟수가 1보다 작거나 1000보다 큰 경우 예외가 발생한다`(inputTryCount: String) {
        assertThrows<IllegalArgumentException> {
            inputValidator.validateTryCount(inputTryCount)
        }
    }

}
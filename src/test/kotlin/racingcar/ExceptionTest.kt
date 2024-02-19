package racingcar

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.view.input.InputValidator

class ExceptionTest {
    private val inputValidator = InputValidator()

    /** 자동차 이름 입력 Test */
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = [",,,"])
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
    @ValueSource(strings = ["a,b,c", "olive", "pobi,woni,jun"])
    fun `자동차 이름을 올바르게 입력하면 예외가 발생하지 않는다`(inputCarNames: String) {
        assertDoesNotThrow {
            inputValidator.validateCarNames(inputCarNames)
        }
    }

    /** 시도할 횟수 입력 Test */
    @ParameterizedTest
    @NullAndEmptySource
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

    @ParameterizedTest
    @ValueSource(strings = ["1", "100", "1000"])
    fun `시도할 횟수를 올바르게 입력하면 예외가 발생하지 않는다`(inputTryCount: String) {
        assertDoesNotThrow {
            inputValidator.validateTryCount(inputTryCount)
        }
    }

}

package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.constants.ErrorMessages
import racingcar.validator.InputValidator

class InputValidatorTest {
    @Test
    fun `입력값이 비어있을 때 예외가 발생한다`() {
        Assertions.assertThatThrownBy {
            InputValidator.validateNotEmpty(" ")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorMessages.EMPTY_INPUT_ERROR)
    }
}

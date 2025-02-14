import Constants.ERROR_DUPLICATED_CAR_NAME_MESSAGE_WITH_INPUT
import Constants.ERROR_EMPTY_CAR_NAME_MESSAGE_WITH_INPUT
import Constants.ERROR_EMPTY_TRY_COUNT_MESSAGE_WITH_INPUT
import Constants.ERROR_IS_NOT_NUMBER_MESSAGE_WITH_INPUT
import Constants.ERROR_OUT_OF_BOUND_CAR_NAME_MESSAGE_WITH_INPUT
import Constants.ERROR_OUT_OF_BOUND_TRY_COUNT_MESSAGE_WITH_INPUT
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    @Test
    fun `자동차의 이름이 공백이면 예외가 발생한다`() {
        val input = " "

        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateCarName(input)
        }.withMessage(ERROR_EMPTY_CAR_NAME_MESSAGE_WITH_INPUT.format(input))
    }

    @Test
    fun `자동차의 이름이 중복되면 예외가 발생한다`() {
        val input = "pobi,pobi"

        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateCarName(input)
        }.withMessage(ERROR_DUPLICATED_CAR_NAME_MESSAGE_WITH_INPUT.format(input))
    }

    @Test
    fun `자동차 이름의 길이가 5자를 넘어가면 예외가 발생한다`() {
        val input = "cronnnnn"

        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateCarName(input)
        }.withMessage(ERROR_OUT_OF_BOUND_CAR_NAME_MESSAGE_WITH_INPUT.format(input))
    }

    @Test
    fun `시도 횟수가 공백이면 예외가 발생한다`() {
        val input = " "

        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateTryCount(input)
        }.withMessage(ERROR_EMPTY_TRY_COUNT_MESSAGE_WITH_INPUT.format(input))
    }

    @Test
    fun `시도 횟수가 숫자가 아니면 예외가 발생한다`() {
        val input = "aa"

        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateTryCount(input)
        }.withMessage(ERROR_IS_NOT_NUMBER_MESSAGE_WITH_INPUT.format(input))
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "1001"])
    fun `시도 횟수가 1에서 1000사이의 숫자가 아니면 예외가 발생한다`(input: String) {
        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateTryCount(input)
        }.withMessage(ERROR_OUT_OF_BOUND_TRY_COUNT_MESSAGE_WITH_INPUT.format(input))
    }
}

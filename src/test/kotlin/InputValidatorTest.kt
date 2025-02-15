import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    private val inputValidator = InputValidator()

    @Test
    fun `자동차의 이름이 공백이면 예외가 발생한다`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            inputValidator.validateName(" ")
        }.withMessage(ERROR_EMPTY_CAR_NAME_MESSAGE)
    }

    @Test
    fun `자동차의 이름이 중복되면 예외가 발생한다`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            inputValidator.validateName("pobi,pobi")
        }.withMessage(ERROR_DUPLICATED_CAR_NAME_MESSAGE)
    }

    @Test
    fun `자동차 이름의 길이가 5자를 넘어가면 예외가 발생한다`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            inputValidator.validateName("cronnnnn")
        }.withMessage(ERROR_OUT_OF_BOUND_CAR_NAME_MESSAGE)
    }

    @Test
    fun `시도 횟수가 공백이면 예외가 발생한다`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            inputValidator.validateTryCount(" ")
        }.withMessage(ERROR_EMPTY_TRY_COUNT_MESSAGE)
    }

    @Test
    fun `시도 횟수가 숫자가 아니면 예외가 발생한다`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            inputValidator.validateTryCount("aa")
        }.withMessage(ERROR_IS_NOT_NUMBER_MESSAGE)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "1001"])
    fun `시도 횟수가 1에서 1000사이의 숫자가 아니면 예외가 발생한다`(input: String) {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            inputValidator.validateTryCount(input)
        }.withMessage(ERROR_OUT_OF_BOUND_TRY_COUNT_MESSAGE)
    }

    companion object {
        private const val ERROR = "[ERROR]"
        const val ERROR_EMPTY_CAR_NAME_MESSAGE = "$ERROR 자동차 이름은 공백일 수 없습니다."
        const val ERROR_DUPLICATED_CAR_NAME_MESSAGE = "$ERROR 중복된 자동차 이름이 있습니다."
        const val ERROR_OUT_OF_BOUND_CAR_NAME_MESSAGE = "$ERROR 자동차 이름의 최대 길이를 초과했습니다."
        const val ERROR_EMPTY_TRY_COUNT_MESSAGE = "$ERROR 시도횟수는 공백일 수 없습니다."
        const val ERROR_IS_NOT_NUMBER_MESSAGE = "$ERROR 시도횟수는 숫자여야만 합니다."
        const val ERROR_OUT_OF_BOUND_TRY_COUNT_MESSAGE = "$ERROR 시도횟수는 1에서 1,000 사이의 숫자여야 합니다."
    }
}

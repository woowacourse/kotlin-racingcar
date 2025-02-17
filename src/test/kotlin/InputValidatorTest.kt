import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    @Test
    fun `자동차의 이름이 공백이면 예외가 발생한다`() {
        val input = " "
        val expectedExceptionMessage = "[ERROR] 자동차 이름은 공백일 수 없습니다.(현재 입력 :  )"

        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateCarName(input)
        }.withMessage(expectedExceptionMessage)
    }

    @Test
    fun `자동차의 이름이 중복되면 예외가 발생한다`() {
        val input = "pobi,pobi"
        val expectedExceptionMessage = "[ERROR] 중복된 자동차 이름이 있습니다.(현재 입력 : pobi,pobi)"

        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateCarName(input)
        }.withMessage(expectedExceptionMessage)
    }

    @Test
    fun `자동차 이름의 길이가 5자를 넘어가면 예외가 발생한다`() {
        val input = "cronnnnn"
        val expectedExceptionMessage = "[ERROR] 자동차 이름의 최대 길이를 초과했습니다.(현재 입력 : cronnnnn)"

        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateCarName(input)
        }.withMessage(expectedExceptionMessage)
    }

    @Test
    fun `시도 횟수가 공백이면 예외가 발생한다`() {
        val input = " "
        val expectedExceptionMessage = "[ERROR] 시도횟수는 공백일 수 없습니다.(현재 입력 :  )"

        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateTryCount(input)
        }.withMessage(expectedExceptionMessage)
    }

    @Test
    fun `시도 횟수가 숫자가 아니면 예외가 발생한다`() {
        val input = "aa"
        val expectedExceptionMessage = "[ERROR] 시도횟수는 숫자여야만 합니다.(현재 입력 : aa)"

        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateTryCount(input)
        }.withMessage(expectedExceptionMessage)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "1001"])
    fun `시도 횟수가 1에서 1000사이의 숫자가 아니면 예외가 발생한다`(input: String) {
        val expectedExceptionMessage = "[ERROR] 시도횟수는 1에서 1,000 사이의 숫자여야 합니다.(현재 입력 : $input)"

        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateTryCount(input)
        }.withMessage(expectedExceptionMessage)
    }
}

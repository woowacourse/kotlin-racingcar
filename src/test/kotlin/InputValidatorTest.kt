import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    @Test
    fun `자동차의 이름이 공백이면 예외가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateName(" ")
        }
    }

    @Test
    fun `자동차의 이름이 중복되면 예외가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateName("pobi,pobi")
        }
    }

    @Test
    fun `자동차 이름의 길이가 5자를 넘어가면 예외가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateName("cronnnnn")
        }
    }

    @Test
    fun `시도 횟수가 공백이면 예외가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateTryCount(" ")
        }
    }

    @Test
    fun `시도 횟수가 숫자가 아니면 예외가 발생한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateTryCount("aa")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "1001"])
    fun `시도 횟수가 1에서 1000사이의 숫자가 아니면 예외가 발생한다`(input: String) {
        assertThatIllegalArgumentException().isThrownBy {
            InputValidator.validateTryCount(input)
        }
    }
}

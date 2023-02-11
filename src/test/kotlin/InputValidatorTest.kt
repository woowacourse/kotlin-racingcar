import domain.InputValidator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["a", "세번", "*", "-3"])
    fun `유효하지 않은 시도 횟수 확인하기`(numberOfTry: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateIsNumeric(numberOfTry)
        }
    }

    @Test
    fun `자동차 이름 입력시 ,를 연속으로 입력한 경우`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateSuccessiveTokenizer("두치,뿌꾸,,,,,")
        }
    }
}

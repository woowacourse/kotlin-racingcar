import domain.InputValidator
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["a", "세번", "다섯", "-3"])
    fun `유효하지 않은 시도 횟수 확인하기`(numberOfTry: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateIsNumeric(numberOfTry)
        }
    }
}

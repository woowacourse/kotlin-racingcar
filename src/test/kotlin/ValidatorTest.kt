import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import util.Validator

class ValidatorTest {

    private val validator = Validator()

    @Test
    fun `자동차들의 이름을 입력받을 때 공백인 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException> {
            validator.checkNames("")
        }
    }
    @ValueSource(strings = ["", "()*"])
    @ParameterizedTest
    fun `입력된 시도하는 숫자가 공백인 경우, 숫자가 아닌 경우 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            validator.checkTryNumber(input)
        }
    }

    @ValueSource(strings = ["0", "101"])
    @ParameterizedTest
    fun `입력된 시도하는 숫자가 1이상 100이하가 아닌 경우 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            validator.checkTryNumber(input)
        }
    }
}

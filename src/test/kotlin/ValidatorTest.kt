import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {

    private val validator = Validator()

    @Test
    fun checkNameTest() {
        assertDoesNotThrow {
            validator.checkName("dool")
        }
    }

    @ValueSource(strings = ["", "abcdef"])
    @ParameterizedTest
    fun checkNameExceptionTest(input: String) {
        assertThrows<IllegalArgumentException> {
            validator.checkName(input)
        }
    }

    @Test
    fun checkTryNumberTest() {
        assertDoesNotThrow {
            validator.checkTryNumber("123")
        }
    }
    @ValueSource(strings = ["", "()*"])
    @ParameterizedTest
    fun checkTryNumberExceptionTest(input: String) {
        assertThrows<IllegalArgumentException> {
            validator.checkTryNumber(input)
        }
    }
}

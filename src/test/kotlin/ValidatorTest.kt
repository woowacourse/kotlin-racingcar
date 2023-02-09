import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import util.Validator

class ValidatorTest {

    private val validator = Validator()

    @Test
    fun checkNamesTest() {
        assertDoesNotThrow {
            validator.checkNames("dool,pobi,woni")
        }
    }

    @ValueSource(strings = ["abcdef,\" \",*()"])
    @ParameterizedTest
    fun checkNamesExceptionTest(input: String) {
        assertThrows<IllegalArgumentException> {
            validator.checkNames(input)
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

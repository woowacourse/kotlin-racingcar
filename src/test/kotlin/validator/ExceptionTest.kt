package validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racing.validators.UserInputValidator

class ExceptionTest {
    private val userInputValidator = UserInputValidator

    @Test
    fun `차 이름이 5글자가 넘으면 exception 발생`() {
        assertThrows<IllegalArgumentException> {
            userInputValidator.validateUserCarNameLength("aaaaaa")
        }
    }

    @Test
    fun `차 이름이 블랭크면 exception 발생`() {
        assertThrows<IllegalArgumentException> {
            userInputValidator.validateUserCarNameBlank("")
        }
    }
}

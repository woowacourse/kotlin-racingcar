package exception

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {

    private val validator = InputValidator()

    @Test
    fun `시도 횟수가 숫자가 아닌 경우 예외가 발생한다`() {
        val input = "100a"
        assertThrows<IllegalArgumentException> {
            validator.checkRoundCount(input)
        }
    }

    @Test
    fun `시도 횟수가 음수인 경우 예외가 발생한다`() {
        val input = "-5"
        assertThrows<IllegalArgumentException> {
            validator.checkRoundCount(input)
        }
    }
}

package exception

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {

    private val validator = Validator()

    @Test
    fun `이름이 5자를 넘으면 예외가 발생한다`() {
        val name = "John Doe"
        assertThrows<IllegalArgumentException> {
            validator.checkCarName(name)
        }
    }

    @Test
    fun `이름이 비어있으면 예외가 발생한다`() {
        val name = " "
        assertThrows<IllegalArgumentException> {
            validator.checkCarName(name)
        }
    }

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

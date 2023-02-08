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
    fun checkRoundCount() {
    }
}

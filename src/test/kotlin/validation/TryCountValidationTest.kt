package validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TryCountValidationTest {

    private val tryCountValidation = TryCountValidation()

    @Test
    fun `시도 횟수가 정수가 아닐 시 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            tryCountValidation.checkTryCountInteger("다섯번")
        }
    }

    @Test
    fun `시도 횟수가 양수가 아닐 시 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            tryCountValidation.checkTryCountPositive("0")
        }
    }
}

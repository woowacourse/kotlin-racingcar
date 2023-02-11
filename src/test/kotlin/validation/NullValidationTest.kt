package validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NullValidationTest(nullValidation: NullValidation) {

    private val nullValidation = NullValidation()

    @Test
    fun `공백 입력 시 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            nullValidation.checkNull("")
        }
    }
}

package validation

import org.junit.jupiter.api.Test

class NameValidationTest {

    private val nameValidation = NameValidation()

    @Test
    fun `이름이 5자 초과 시 예외를 발생한다`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            nameValidation.checkNameRange("avante")
        }
    }

    @Test
    fun `이름에 한글이 들어갈 시 예외를 발생한다`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            nameValidation.checkCarNameEnglishNumber("케이")
        }
    }

    @Test
    fun `이름에 특수부호가 들어갈 시 예외를 발생한다`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            nameValidation.checkCarNameEnglishNumber("k''")
        }
    }
}

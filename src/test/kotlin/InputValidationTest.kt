import validation.NameValidation
import validation.NullValidation
import validation.TryCountValidation
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidationTest {

    @Test
    fun `공백 입력 시 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            NullValidation.checkNull("")
        }
    }

    @Test
    fun `이름이 5자 초과 시 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            NameValidation.checkNameRange("avante")
        }
    }

    @Test
    fun `이름이 공백 일 시 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            NameValidation.checkNameRange("")
        }
    }

    @Test
    fun `이름이 영어와 숫자 외의 문자가 들어갈 시 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            NameValidation.checkCarNameEnglishNumber("케이5")
        }
    }

    @Test
    fun `시도 횟수가 정수가 아닐 시 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            TryCountValidation.checkTryCountInteger("다섯번")
        }
    }

    @Test
    fun `시도 횟수가 양수가 아닐 시 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            TryCountValidation.checkTryCountPositive("0")
        }
    }
}

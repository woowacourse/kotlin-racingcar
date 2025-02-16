package racingcar.utils

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    private val validator = Validator()

    @Test
    fun `자동차 이름이 중복일 때 예외 발생`() {
        val value = "a,b,b"
        assertThrows<IllegalArgumentException> {
            validator.validateCarName(value)
        }
    }

    @Test
    fun `자동차 이름이 빈 값일 때 예외 발생`() {
        val value = ""
        assertThrows<IllegalArgumentException> {
            validator.validateCarName(value)
        }
    }

    @Test
    fun `자동차 이름의 길이가 5자가 초과일 때 예외 발생`() {
        val value = "ascdef"
        assertThrows<IllegalArgumentException> {
            validator.validateTryCount(value)
        }
    }

    @Test
    fun `시도횟수가 빈 값일 때 예외 발생`() {
        val value = ""
        assertThrows<IllegalArgumentException> {
            validator.validateTryCount(value)
        }
    }

    @Test
    fun `시도횟수를 올바르지 않게 입력했을 때 예외 발생`() {
        val value = "asc"
        assertThrows<IllegalArgumentException> {
            validator.validateTryCount(value)
        }
    }
}

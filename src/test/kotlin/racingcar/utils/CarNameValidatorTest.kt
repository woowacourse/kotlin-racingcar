package racingcar.utils

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.CarNameValidator

class CarNameValidatorTest {
    private val validator = CarNameValidator()

    @Test
    fun `자동차 이름이 중복일 때 예외 발생`() {
        val value = listOf("a", "a", "b")
        assertThrows<IllegalArgumentException> {
            validator.validateCarName(value)
        }
    }

    @Test
    fun `자동차 이름이 빈 값일 때 예외 발생`() {
        val value = listOf("")
        assertThrows<IllegalArgumentException> {
            validator.validateCarName(value)
        }
    }

    @Test
    fun `자동차 이름의 길이가 5자가 초과일 때 예외 발생`() {
        val value = listOf("가나다라마바", "가", "나")
        assertThrows<IllegalArgumentException> {
            validator.validateCarName(value)
        }
    }
}

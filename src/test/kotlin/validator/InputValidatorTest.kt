package validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(
        strings = ["creammm", " "],
    )
    fun `자동차 이름은 5자를 초과할 수 없으며, 공백이 불가하다`(name: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateCarName(name)
        }
    }

    @Test
    fun `자동차 이름은 중복 될 수 없다`() {
        val names = listOf("tama", "tama")
        assertThrows<IllegalArgumentException> {
            InputValidator.validateDuplicatedName(names)
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["0", " ", "seven"],
    )
    fun `시도 횟수는 정수 형태로 입력되어야 한다`(tryNumber: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateTryNumber(tryNumber)
        }
    }
}

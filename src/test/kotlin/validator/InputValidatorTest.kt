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
    fun `개별 자동차 이름 유효성 검사`(name: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateCarName(name)
        }
    }

    @Test
    fun `자동차 이름 중복 검사`() {
        val names = listOf("tama", "tama")
        assertThrows<IllegalArgumentException> {
            InputValidator.validateDuplicatedName(names)
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["0", " ", "seven"],
    )
    fun `시도 횟수 유효성 검사`(tryNumber: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateTryNumber(tryNumber)
        }
    }
}

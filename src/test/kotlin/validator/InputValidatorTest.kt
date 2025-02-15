package validator

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(
        strings = ["creammm", "tamatama"],
    )
    fun `각 자동차 이름은 5자를 초과할 수 없다`(name: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateCarName(name)
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["", " ", "          "],
    )
    fun `각 자동차 이름은 공백이 불가하다`(name: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateCarName(name)
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["한번", " ", "seven"],
    )
    fun `시도 횟수는 숫자로 입력해야 한다`(tryNumber: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateTryNumber(tryNumber)
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["0", "-1"],
    )
    fun `시도 횟수는 0보다 커야한다`(tryNumber: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateTryNumber(tryNumber)
        }
    }
}

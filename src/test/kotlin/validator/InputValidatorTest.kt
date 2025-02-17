package validator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    @Test
    fun `자동차 이름은 중복 될 수 없다`() {
        val names = listOf("tama", "tama")
        val exception =
            assertThrows<IllegalArgumentException> {
                InputValidator.validateDuplicatedName(names)
            }
        assertThat(exception.message).isEqualTo("자동차 이름은 중복될 수 없습니다.")
    }

    @ParameterizedTest
    @ValueSource(
        strings = [" ", "seven", "-3"],
    )
    fun `시도 횟수는 정수 형태로 입력되어야 한다`(tryNumber: String) {
        val exception =
            assertThrows<IllegalArgumentException> {
                InputValidator.validateTryNumber(tryNumber)
            }
        assertThat(exception.message).isEqualTo("잘못 입력된 시도 횟수 -> $tryNumber : 시도 횟수는 숫자로 입력해주세요.")
    }

    @Test
    fun `시도 횟수는 0보다 커야한다`() {
        val tryNumber = "0"
        val exception =
            assertThrows<IllegalArgumentException> {
                InputValidator.validateTryNumber(tryNumber)
            }
        assertThat(exception.message).isEqualTo("잘못 입력된 시도 횟수 -> $tryNumber : 시도 횟수는 0보다 커야 합니다.")
    }
}

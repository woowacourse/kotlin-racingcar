package validation

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TryCountValidationTest {

    private val tryCountValidation = TryCountValidation()

    @Test
    fun `시도 횟수가 정수가 아닐 시 false를 반환한다`() {
        val actual = tryCountValidation.isTryCountInteger("하하")
        assertThat(actual).isEqualTo(false)
    }

    @Test
    fun `시도 횟수가 양수가 아닐 시 false를 반환한다`() {
        val actual = tryCountValidation.isTryCountPositive("0")
        assertThat(actual).isEqualTo(false)
    }
}

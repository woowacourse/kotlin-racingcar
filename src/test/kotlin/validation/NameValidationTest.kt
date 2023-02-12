package validation

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NameValidationTest {

    private val nameValidation = NameValidation()

    @Test
    fun `이름이 5자 초과 시 true를 반환한다`() {
        val actual = nameValidation.isNameLengthExceed("aaabbb")
        assertThat(actual).isEqualTo(true)
    }

    @Test
    fun `이름에 한글이 들어갈 시 false를 반환한다`() {
        val actual = nameValidation.isCarNameEnglishNumber("케이")
        assertThat(actual).isEqualTo(false)
    }

    @Test
    fun `이름에 특수부호가 들어갈 시 false를 반환한다`() {
        val actual = nameValidation.isCarNameEnglishNumber("..")
        assertThat(actual).isEqualTo(false)
    }
}

package view.validator

import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {

    @Test
    fun `자동차 이름 입력 성공 테스트`() {
        assertThatCode {
            InputValidator.validateCarNames("wooah,토마스,멘델")
        }.doesNotThrowAnyException()
    }

    @ParameterizedTest
    @ValueSource(strings = ["men2e,토마스", "mendel,hi", "hi"])
    fun `자동차 이름 입력 실패 테스트`(names: String) {
        assertThatIllegalArgumentException().isThrownBy { InputValidator.validateCarNames(names) }
    }
}

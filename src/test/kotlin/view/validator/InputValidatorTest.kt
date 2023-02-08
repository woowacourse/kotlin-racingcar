package view.validator

import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test

class InputValidatorTest {

    @Test
    fun `자동차 이름 입력 성공 테스트`() {
        assertThatCode {
            InputValidator.validateCarNames("wooah,토마스,멘델")
        }.doesNotThrowAnyException()
    }
}

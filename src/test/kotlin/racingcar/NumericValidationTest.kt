package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.validation.NumericValidator

class NumericValidationTest {
    @Test
    fun `빈 값일 때 예외가 발생하며 숫자를 입력해야 합니다 메시지가 발생한다`() {
        Assertions.assertThatThrownBy {
            NumericValidator("  ")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 빈 값을 입력하셨습니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["가나다, abc, ###, 2147483648"])
    fun `숫자가 아닐 때 예외가 발생하며 숫자를 입력해야 합니다 메시지가 발생한다`(value: String) {
        Assertions.assertThatThrownBy {
            NumericValidator(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 숫자를 입력해야 합니다.")
    }
}

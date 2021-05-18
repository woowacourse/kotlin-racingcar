package practice

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class StringCalculatorTest {

    @DisplayName("잘못된 입력값 예외처리")
    @ParameterizedTest
    @ValueSource(strings = ["", "  ", "1 : 3", "1 + a"])
    internal fun validateInput(input: String?) {
        Assertions.assertThatThrownBy { StringCalculator.calculate(input!!) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("올바르지 않은 입력값입니다.")
    }

    @DisplayName("잘못된 수식인 경우 예외처리")
    @ParameterizedTest
    @ValueSource(strings = ["1 2", "+", "1 +", "+ 1", "1+2"])
    internal fun validateExpression(input: String?) {
        Assertions.assertThatThrownBy { StringCalculator.calculate(input!!) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("잘못된 수식입니다.")
    }

    @DisplayName("계산 기능")
    @Test
    internal fun calculate() {
        assertAll(
            { Assertions.assertThat(StringCalculator.calculate("1 + 2")).isEqualTo(3) },
            { Assertions.assertThat(StringCalculator.calculate("8 + 2 / 2")).isEqualTo(5) },
            { Assertions.assertThat(StringCalculator.calculate("4 / 2 + 2 * 3")).isEqualTo(12) }
        )
    }
}
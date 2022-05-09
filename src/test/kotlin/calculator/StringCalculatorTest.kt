package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class StringCalculatorTest {
    private val stringCalculator = StringCalculator()

    @Test
    @DisplayName("공백이 입력된 경우 IllegalArgumentException 예외가 발생한다.")
    fun splitAndSum_blank() {
        assertThrows<IllegalArgumentException> {
            stringCalculator.calculate("")
        }
    }

    @Test
    @DisplayName("덧셈을 계산한다.")
    fun sum() {
        assertThat(stringCalculator.calculate("6 + 3")).isEqualTo(9)
    }

    @Test
    @DisplayName("뺄셈을 계산한다.")
    fun subtract() {
        assertThat(stringCalculator.calculate("6 - 3")).isEqualTo(3)
    }

    @Test
    @DisplayName("곱셈을 계산한다.")
    fun multiply() {
        assertThat(stringCalculator.calculate("6 * 3")).isEqualTo(18)
    }

    @Test
    @DisplayName("나눗셈을 계산한다.")
    fun divide() {
        assertThat(stringCalculator.calculate("6 / 3")).isEqualTo(2)
    }
}

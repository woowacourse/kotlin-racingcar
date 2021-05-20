package calculator

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class StringCalculatorTest {
    @ParameterizedTest
    @MethodSource("parameterProvider")
    internal fun `사칙 연산 확인`(input: String, expected: Int) {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @EmptySource
    internal fun `입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw`(input: String) {
        val stringCalculator = StringCalculator()
        assertThatIllegalArgumentException().isThrownBy { stringCalculator.calculate(input) }
    }

    @Test
    internal fun `사칙연산 기호가 아닌 경우 IllegalArgumentException throw`() {
        val stringCalculator = StringCalculator()
        assertThatIllegalArgumentException().isThrownBy { stringCalculator.calculate("10 . 2 = 3") }
    }

    companion object {
        @JvmStatic
        fun parameterProvider() = Stream.of(
            Arguments.of("1 + 2", 3),
            Arguments.of("1 + 2 + 3", 6),
            Arguments.of("3 - 2", 1),
            Arguments.of("10 - 2 - 3", 5),
            Arguments.of("3 * 2", 6),
            Arguments.of("10 * 2 * 3", 60),
            Arguments.of("10 / 2", 5),
            Arguments.of("20 / 2 / 10", 1)
        )
    }
}
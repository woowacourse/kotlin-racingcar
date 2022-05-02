package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorTest {

    @Test
    fun plus() {
        assertThat(StringCalculator.calculate("1 + 2")).isEqualTo(3)
    }

    @Test
    fun minus() {
        assertThat(StringCalculator.calculate("6 - 3")).isEqualTo(3)
    }

    @Test
    fun multiply() {
        assertThat(StringCalculator.calculate("2 * 3")).isEqualTo(6)
    }

    @Test
    fun divide() {
        assertThat(StringCalculator.calculate("4 / 2")).isEqualTo(2)
    }

    @Test
    fun multiOperators() {
        assertThat(StringCalculator.calculate("3 + 5 - 2")).isEqualTo(6)
    }

    @Test
    fun divideZero() {
        assertThrows<IllegalArgumentException> { StringCalculator.calculate("10 / 0") }
    }
}

package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorTest {

    @Test
    fun add() {
        // given
        val str = "2 + 3"

        // when
        val result = StringCalculator.calculate(str)

        // then
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun minus() {
        // given
        val str = "10 - 5"

        // when
        val result = StringCalculator.calculate(str)

        // then
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun multiply() {
        // given
        val str = "2 * 5"

        // when
        val result = StringCalculator.calculate(str)

        // then
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun divide() {
        // given
        val str = "10 / 2"

        // when
        val result = StringCalculator.calculate(str)

        // then
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun multipleOperators() {
        // given
        val str = "1 + 2 * 3 / 3"

        // when
        val result = StringCalculator.calculate(str)

        // then
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun invalidExpression() {
        // given & when
        val str = "3 2 *"

        // then
        assertThrows <IllegalArgumentException> { StringCalculator.calculate(str) }
    }

    @Test
    fun invalidOperator() {
        // given & when
        val str = "3 @ 2"

        // then
        assertThrows <IllegalArgumentException> { StringCalculator.calculate(str) }
    }

    @Test
    fun divideByZero() {
        // given & when
        val str = "3 / 0"

        // then
        assertThrows <IllegalArgumentException> { StringCalculator.calculate(str) }
    }
}

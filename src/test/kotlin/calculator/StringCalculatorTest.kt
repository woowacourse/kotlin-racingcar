package calculator

import io.kotest.matchers.throwable.shouldHaveMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {

    private val calculator = StringCalculator()

    @NullAndEmptySource
    fun `Null 혹은 Empty가 들어올 경우 0이 반환된다`(string: String?) {
        assertThat(calculator.add(string)).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    fun `숫자 하나만 들어올 경우 그 숫자를 반환한다`(input: String) {
        assertThat(calculator.add(input)).isEqualTo(input.toInt())
    }

    @ParameterizedTest
    @CsvSource(value = ["'1,2', 3", "'2,4', 6"])
    fun `숫자 두개가 컴마로 구분해 들어올 경우 두 숫자의 합을 반환한다`(input: String, result: Int) {
        assertThat(calculator.add(input)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(value = ["'1,2:3', 6", "'3:3,6', 12"])
    fun `구분자는 컴마 외에 콜론도 이용할 수 있다`(input: String, result: Int) {
        assertThat(calculator.add(input)).isEqualTo(result)
    }

    @Test
    fun `커스텀 구분자를 만들어 사용할 수 있다`() {
        assertThat(calculator.add("//;\n1;2;3")).isEqualTo(6)
    }

    @Test
    fun `음수가 존재할 경우 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> { calculator.add("-1,2,3") }
            .shouldHaveMessage("음수를 입력하면 안됩니다.")
    }
}

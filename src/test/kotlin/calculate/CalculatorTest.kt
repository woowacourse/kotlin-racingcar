package calculate

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("계산기 기능 테스트")
internal class CalculatorTest {

    @DisplayName("문자열이 입력됐을 때, 계산하는 기능을 테스트한다")
    @ParameterizedTest
    @CsvSource(
        value = ["1 + 2 - 1 * 3:6", "0 + 3 * 2 / 3:2", "-2 + 3 - 1:0"], delimiter = ':'
    )
    internal fun `test calculate`(input: String, expected: Int) {
        //given
        val calculator = Calculator()

        //when
        val result = calculator.operate(input)

        //then
        assertThat(result).isEqualTo(Number(expected))
    }

    @DisplayName("유효하지 않은 숫자가 들어왔을 때, 계산하는 기능을 테스트한다")
    @Test
    internal fun `test calculate if not validate number`() {
        //given
        val input = "  + 2"
        val calculator = Calculator()

        //when //then
        assertThatThrownBy { calculator.operate(input) }
            .isExactlyInstanceOf(Class.forName("IllegalArgumentException"))
        assertThat(1).isEqualTo(1)
    }
}

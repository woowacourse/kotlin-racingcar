import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.lang.IllegalArgumentException

@DisplayName("문자열계산기")
class StringCalculatorTest {

    private val stringCalculator = StringCalculator()

    @ParameterizedTest(name = "[{index}] {0} + {1} = {2}")
    @CsvSource("1,2,3.0", "2,3,5.0", "3,10,13.0")
    internal fun add(a: String, b: String, answer: String) {
        val result = stringCalculator.add(a, b)

        assertThat(result).isEqualTo(answer.toFloat())
    }

    @ParameterizedTest(name = "[{index}] {0} - {1} = {2}")
    @CsvSource("1,2,-1.0", "7,2,5.0", "3,3,0.0")
    internal fun subtract(a: String, b: String, answer: String) {
        val result = stringCalculator.subtract(a, b)

        assertThat(result).isEqualTo(answer.toFloat())
    }

    @ParameterizedTest(name = "[{index}] {0} * {1} = {2}")
    @CsvSource("1,2,2.0", "7,-2,-14.0", "3,0,0.0")
    internal fun multiply(a: String, b: String, answer: String) {
        val result = stringCalculator.multiply(a, b)

        assertThat(result).isEqualTo(answer.toFloat())
    }

    @ParameterizedTest(name = "[{index}] {0} / {1} = {2}")
    @CsvSource("1,2,0.5", "8,-2,-4")
    internal fun divide(a: String, b: String, answer: String) {
        val result = stringCalculator.divide(a, b)

        assertThat(result).isEqualTo(answer.toFloat())
    }

    @DisplayName("실패 - 0으로 나누는 경우")
    @Test
    internal fun divideFail() {
        assertThatThrownBy { stringCalculator.divide("1", "0") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("0으로 나눌 수 없어요")
    }

    @DisplayName("실패 - 빈문자열 경우")
    @Test
    internal fun addFail() {
        assertThatThrownBy { stringCalculator.add("", "0") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("빈 문자열이면 안 됩니다.")
    }

    @DisplayName("종합계산기: 2 + 3 * 4 / 2 = 10.0")
    @Test
    internal fun totalCalculator() {

        val result = stringCalculator.calculate("2 + 3 * 4 / 2")

        assertThat(result).isEqualTo("10.0")
    }

    @DisplayName("종합계산기: 2 + 13 * 4 / 2 - 14  = 16.0")
    @Test
    internal fun totalCalculator1() {

        val result = stringCalculator.calculate("2 + 13 * 4 / 2 - 14")

        assertThat(result).isEqualTo("16.0")
    }

    @DisplayName("실패 - 사칙연산 기호가 아닌 경우")
    @Test
    internal fun totalCalculatorFail() {
        assertThatThrownBy { stringCalculator.calculate("2 + 3 * 4 // 2") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("사칙연산 기호가 아니네요.")
    }
}

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.lang.IllegalArgumentException

@DisplayName("문자열계산기")
class StringCalculatorTest {

    val stringCalculator = StringCalculator()

    @ParameterizedTest(name = "[{index}] {0} + {1} = {2}")
    @CsvSource("1,2,3", "2,3,5", "3,10,13")
    internal fun add(a: String, b: String, answer: String) {
        val result = stringCalculator.add(a, b)

        assertThat(result).isEqualTo(answer.toInt())
    }

    @ParameterizedTest(name = "[{index}] {0} - {1} = {2}")
    @CsvSource("1,2,-1", "7,2,5", "3,3,0")
    internal fun subtract(a: String, b: String, answer: String) {
        val result = stringCalculator.subtract(a, b)

        assertThat(result).isEqualTo(answer.toInt())
    }

    @ParameterizedTest(name = "[{index}] {0} * {1} = {2}")
    @CsvSource("1,2,2", "7,-2,-14", "3,0,0")
    internal fun multiply(a: String, b: String, answer: String) {
        val result = stringCalculator.multiply(a, b)

        assertThat(result).isEqualTo(answer.toInt())
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

}
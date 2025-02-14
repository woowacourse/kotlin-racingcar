import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.view.InputView

class InputTest {
    private val inputView = InputView()

    @Test
    fun `자동차 이름은 공백인 경우 예외가 발생한다`() {
        val input = listOf("", "a", "b")
        assertThrows<IllegalArgumentException> { inputView.validateCarName(input) }
    }

    @Test
    fun `자동차 이름이 5글자를 초과하는 경우 예외가 발생한다`() {
        val input = listOf("우아한테크코스", "a", "b")
        assertThrows<IllegalArgumentException> { inputView.validateCarName(input) }
    }

    @Test
    fun `자동차 이름에 중복이 있는 경우 예외가 발생한다`() {
        val input = listOf("a", "a", "b")
        assertThrows<IllegalArgumentException> { inputView.validateCarName(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["S", "9999999999", " ", ""])
    fun `경주 횟수가 정수가 아닌 경우 예외를 발생한다`(count: String) {
        assertThrows<IllegalArgumentException> { inputView.validateCount(count) }
    }

    @Test
    fun `경주 횟수가 1보다 작은 경우 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> { inputView.validateCount("0") }
    }
}

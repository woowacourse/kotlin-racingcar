import controller.RacingGameController
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import view.InputView
import view.OutputView

class InputTest {
    private val initialInput = System.`in`
    private val raceController = RacingGameController(InputView(), OutputView())

    @BeforeEach
    fun resetInput() {
        System.setIn(initialInput)
    }

    @AfterEach
    fun restoreSystemInput() {
        System.setIn(initialInput)
    }

    private fun setInput(input: String) {
        System.setIn(input.byteInputStream())
    }

    @Test
    fun `중복된 이름이 입력되면 에러가 발생한다`() {
        assertThatThrownBy {
            setInput("hwan,hwan")
            raceController.getCarName()
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["-3", "0", "-10"],
    )
    fun `시도 횟수로 0 이하의 숫자가 입력되면 에러가 발생한다`(input: String) {
        assertThatThrownBy {
            setInput(input)
            raceController.getTryCount()
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `시도 횟수로 숫자가 아닌 문자가 입력되면 에러가 발생한다`() {
        assertThatThrownBy {
            setInput("a")
            raceController.getTryCount()
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `자동차 이름을 입력받지 않으면 에러가 발생한다`() {
        assertThatThrownBy {
            setInput("\n")
            raceController.getCarName()
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}

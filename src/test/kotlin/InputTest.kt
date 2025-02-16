import controller.RacingGameController
import model.Car
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
    fun `자동차 이름은 5자를 초과할 수 없다`() {
        assertThatThrownBy { Car("hwannow") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `자동차 이름은 중복될 수 없다`() {
        assertThatThrownBy {
            setInput("hwan,hwan")
            raceController.getCarName()
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["-3", "0", "-10"],
    )
    fun `시도 횟수는 0 이하일 수 없다`(input: String) {
        assertThatThrownBy {
            setInput(input)
            raceController.getTryCount()
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력받은 시도 횟수는 숫자 이외의 문자일 수 없다`() {
        assertThatThrownBy {
            setInput("a")
            raceController.getTryCount()
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `자동차 이름을 아무것도 입력받지 않을 수 없다`() {
        assertThatThrownBy {
            setInput("\n")
            raceController.getCarName()
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}

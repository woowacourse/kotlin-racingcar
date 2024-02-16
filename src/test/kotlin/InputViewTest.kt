import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {
    @Test
    fun `입력값은 모두 숫자여야한다`() {
        val inputView = InputView()
        assertThrows<IllegalArgumentException>("입력값은 모두 양수여야한다") {
            inputView.inputTrialCount("-1")
        }
    }
}

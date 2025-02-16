import view.InputView
import java.io.ByteArrayInputStream

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputTest {
    @ParameterizedTest
    @ValueSource(strings = ["", "a", "1.23", "2147483648"])
    fun `경주 횟수가 정수가 아닐 경우 예외가 발생한다`(value: String) {
        assertThrows<IllegalArgumentException> {
            System.setIn(ByteArrayInputStream(value.toByteArray()))
            InputView.readRounds()
        }
    }
}

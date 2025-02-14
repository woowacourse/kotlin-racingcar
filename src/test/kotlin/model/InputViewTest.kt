package model

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.view.InputView
import java.io.ByteArrayInputStream

class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = ["", " ", "car12345", "1", "car, car", "car1, car12345"])
    fun `입력 값으로부터 자동차 이름 검증 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            InputView.inputCarNames()
            setConsoleInput(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "0", "-1"])
    fun `입력 값으로부터 경주 실행 횟수 검증 예외 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            InputView.inputRacingCount()
            setConsoleInput(input)
        }
    }

    private fun setConsoleInput(input: String) {
        System.setIn(ByteArrayInputStream(input.toByteArray()))
    }
}

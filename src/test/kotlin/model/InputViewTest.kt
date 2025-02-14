package model

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.view.InputView
import java.io.ByteArrayInputStream

class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = ["car1, car2", "car1, car2, car3", "car1, car2,", ",car1,car2"])
    fun `자동차 이름 입력 검증 테스트`(input: String) {
        println(input.split(",").size)
        setConsoleInput(input)
        assertDoesNotThrow {
            InputView.inputCarNames()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", ",", ",,", " , , "])
    fun `자동차 이름 입력 검증 예외 테스트`(input: String) {
        setConsoleInput(input)
        assertThrows<IllegalArgumentException> {
            InputView.inputCarNames()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "4"])
    fun `경주 실행 횟수 입력 검증 테스트`(input: String) {
        setConsoleInput(input)
        assertDoesNotThrow {
            InputView.inputRacingCount()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "0", "-1", "1.1", "1,2"])
    fun `경주 실행 횟수 입력 검증 예외 테스트`(input: String) {
        setConsoleInput(input)
        assertThrows<IllegalArgumentException> {
            InputView.inputRacingCount()
        }
    }

    private fun setConsoleInput(input: String) {
        System.setIn(ByteArrayInputStream(input.toByteArray()))
    }
}

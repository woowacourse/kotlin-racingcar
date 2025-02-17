package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.view.InputView

class ApplicationTest {
    @Test
    fun `자동차 이름은 5자를 초과할 수 없다`() {
        assertThat(InputView().checkCarNameValid("5자 이상의 자동차 이름")).isFalse()
    }

    @ValueSource(strings = ["", "0", "-1", "1.1", "asd", "${Int.MAX_VALUE + 1}"])
    @ParameterizedTest
    fun `시도횟수는 1 이상의 숫자여야 한다`(round: String) {
        assertThat(InputView().checkRoundValid(round)).isFalse()
    }
}

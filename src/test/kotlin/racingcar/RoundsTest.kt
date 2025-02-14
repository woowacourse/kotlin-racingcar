package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Rounds

class RoundsTest {
    @Test
    fun `빈값이 전달되면 빈 값을 입력하셨습니다 에러 메시지가 발생한다`() {
        Assertions.assertThatThrownBy {
            Rounds("")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 빈 값을 입력하셨습니다.")
    }

    @Test
    fun `시도 횟수 입력값이 음수일 때 1에서 10 사이의 수를 입력해야 합니다 메시지가 발생한다`() {
        Assertions.assertThatThrownBy {
            Rounds("-1")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 1에서 10 사이의 수를 입력해야 합니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["가나다, abc, ###, 2147483648"])
    fun `시도 횟수 입력값이 숫자가 아닐 때 숫자를 입력해야 합니다 메시지가 발생한다`(value: String) {
        Assertions.assertThatThrownBy {
            Rounds(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 숫자를 입력해야 합니다.")
    }
}
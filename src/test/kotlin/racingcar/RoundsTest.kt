package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.model.Rounds

class RoundsTest {
    @Test
    fun `시도 횟수 입력값이 음수일 때 1에서 10 사이의 수를 입력해야 합니다 메시지가 발생한다`() {
        Assertions.assertThatThrownBy {
            Rounds(-1)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] 1에서 10 사이의 수를 입력해야 합니다.")
    }
}

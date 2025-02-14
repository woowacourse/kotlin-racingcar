package test

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import parseToRound

class RoundTest {
    @Test
    fun `시도횟수는 1 이상의 숫자여야 한다`() {
        Assertions.assertThatThrownBy({ parseToRound("0") }).hasMessage("시도할 횟수는 1 이상의 자연수여야 합니다. 다시 입력해주세요.")
        Assertions.assertThatThrownBy({ parseToRound("-1") }).hasMessage("시도할 횟수는 1 이상의 자연수여야 합니다. 다시 입력해주세요.")
        Assertions.assertThatThrownBy({ parseToRound("One") }).hasMessage("시도할 횟수는 1 이상의 자연수여야 합니다. 다시 입력해주세요.")
    }
}

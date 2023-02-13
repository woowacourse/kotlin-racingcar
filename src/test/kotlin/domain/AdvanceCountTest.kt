package domain

import common.ERROR_MESSAGE_FORMAT
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class AdvanceCountTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 101])
    fun `생성할 때 1 이상 100 이하가 아닌 값이 주어지면 예외 메세지를 포함한 IllegalArgumentException을 던진다`(count: Int) {
        assertThatIllegalArgumentException().isThrownBy { AdvanceCount(count) }
            .withMessageContaining(ERROR_MESSAGE_FORMAT.format("전진 횟수는 최소 1회에서 최대 100회 사이여야 합니다."))
    }
}

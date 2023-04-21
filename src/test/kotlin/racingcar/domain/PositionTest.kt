package racingcar.domain

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PositionTest {

    @Test
    fun `포지션은 0 이상인 값만 가능하다`() {
        assertThrows<IllegalArgumentException> { Position(-1) }
            .message.shouldBe("위치는 음수일 수 없습니다")
    }

    @Test
    fun `포지션을 증가시킨다`() {
        val position = Position()

        val increase = position.increase()

        assertThat(increase).isEqualTo(Position(1))
    }
}

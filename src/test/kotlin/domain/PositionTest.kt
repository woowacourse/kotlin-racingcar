package domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class PositionTest {
    @Test
    @DisplayName("Position 생성")
    internal fun constructor() {
        assertThat(Position()).isNotNull
    }

    @Test
    @DisplayName("1회 전진")
    internal fun move() {
        assertThat(Position().move()).isEqualTo(Position(1))
    }

    @Test
    @DisplayName("위치값이 음수인 경우 예외")
    internal fun validate_negative() {
        assertThatIllegalArgumentException().isThrownBy { Position(-1) }
    }
}
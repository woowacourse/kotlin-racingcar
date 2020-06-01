package domain

import org.assertj.core.api.Assertions.assertThat
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
}
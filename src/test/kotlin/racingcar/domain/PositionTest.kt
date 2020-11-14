package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class PositionTest {

    @Test
    fun init() {
        assertDoesNotThrow { Position(0) }
        assertThatIllegalArgumentException().isThrownBy { Position(-1) }
    }

    @Test
    fun go() {
        val position = 0
        assertThat(Position(position).go().position).isEqualTo(position + 1)
    }
}
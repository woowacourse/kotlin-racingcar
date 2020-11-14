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
    fun plus() {
        val position = 0
        assertThat(Position(position).plus().position).isEqualTo(position + 1)
    }
}
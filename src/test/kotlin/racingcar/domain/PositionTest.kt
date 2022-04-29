package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class PositionTest {

    @Test
    fun notPositive() {
        assertThatThrownBy { Position(-1) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun increaseDistance() {
        val position = Position(0)

        val increased = position.increase()

        assertThat(increased.distance).isEqualTo(1)
    }
}
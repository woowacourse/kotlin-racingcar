package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class PositionTest {

    @Test
    fun notPositive() {
        assertThatIllegalArgumentException().isThrownBy { Position(-1) }
    }

    @Test
    fun increaseDistance() {
        val strategy = RandomMovingStrategy((0..9), 0)
        val position = Position()

        val increased = position.increase(strategy)

        assertThat(increased.distance).isEqualTo(1)
    }
}
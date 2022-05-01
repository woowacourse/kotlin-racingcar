package racingcar.domain

import org.assertj.core.api.Assertions.*

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class MovingStrategyTest {

    @Test
    fun moveForwardFail() {
        // given
        val range = (0..9)
        val threshold = 10
        val strategy = RandomMovingStrategy(range, threshold)

        // when
        val movable = strategy.isMovable()

        // then
        assertThat(movable).isFalse
    }

    @Test
    fun moveForwardSuccess() {
        // given
        val range = (0..9)
        val threshold = 0
        val strategy = RandomMovingStrategy(range, threshold)

        // when
        val movable = strategy.isMovable()

        // then
        assertThat(movable).isTrue
    }
}
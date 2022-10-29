package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PositionTest {

    @Test
    fun 위치값이_음수면_예외를_반환한다() {
        shouldThrow<IllegalArgumentException> {
            Position(-1)
        }
    }

    @Test
    fun eqhc() {
        val position1 = Position(1)
        val position2 = Position(1)

        position1.shouldBe(position2)
    }
}

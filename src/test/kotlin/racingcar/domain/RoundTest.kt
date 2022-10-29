package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RoundTest {

    @Test
    fun 시도_횟수가_0이하면_예외를_반환한다() {
        shouldThrow<IllegalArgumentException> {
            Round(0)
        }
    }
}

package racingcar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RoundTest {

    @Test
    fun 시도_횟수가_0이하면_예외를_반환한다() {
        assertThrows<IllegalArgumentException> {
            Round(0)
        }
    }
}

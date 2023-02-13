package racingcar.entity

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class AttemptCountTest {
    @Test
    fun `시도 회수가 1 미만이면 IllegalArgumentException을 발생시킨다`() {
        assertThrows<IllegalArgumentException> {
            AttemptCount(0)
        }
    }
}
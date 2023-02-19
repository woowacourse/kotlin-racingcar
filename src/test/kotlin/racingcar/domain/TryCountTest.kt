package racingcar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TryCountTest {

    @Test
    fun `시도 횟수가 1 미만일 때 에러가 발생합니다`(input: Int) {
        assertThrows<IllegalArgumentException> {
            TryCount(0)
        }
    }
}

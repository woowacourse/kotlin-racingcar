package model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TryCountTest {
    @Test
    fun `시도 횟수가 정수가 아닐 시 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            TryCount("다섯")
        }
    }

    @Test
    fun `시도 횟수가 양수가 아닐 시 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> {
            TryCount("0")
        }
    }
}

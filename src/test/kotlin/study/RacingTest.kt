package study

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.model.Racing

class RacingTest {
    @Test
    fun `랜덤값이 타겟숫자보다 큰 경우에 true를 반환하는 경우 테스트`() {
        val racing = Racing()
        val result = racing.shouldMove(4, 9)

        assertTrue(result)
    }

    @Test
    fun `랜덤값이 타겟숫자보다 작은 경우에 false 반환하는 경우 테스트`() {
        val racing = Racing()
        val result = racing.shouldMove(0, 3)

        assertFalse(result)
    }
}

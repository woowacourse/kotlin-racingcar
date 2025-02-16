package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GenerateRandomNumberTest {
    @Test
    fun `랜덤한 숫자가 0~9 사이의 범위 내의 숫자인지 테스트`() {
        val expected = true
        val result = GenerateRandomNumber().randomNumber() in 0..9

        assertEquals(expected, result)
    }
}

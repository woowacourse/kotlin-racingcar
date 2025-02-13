package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GenerateRandomNumberTest {
    @Test
    fun `랜덤 숫자 범위 테스트`() {
        val expected = true
        val result = GenerateRandomNumber().randomNumber() in 0..9

        assertEquals(expected, result)
    }
}

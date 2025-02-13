package racingcar.utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.GenerateRandomNumber
import racingcar.utils.ErrorHandler.validCarName
import racingcar.utils.ErrorHandler.validTryCount

class ErrorHandlerTest {
    @Test
    fun `자동차 이름이 중복일 때 예외 발생`() {
        val value = "a,b,b"
        val expectedMessage = "[ERROR] 자동차 이름을 다시 입력해주세요."
        val result =
            assertThrows<IllegalArgumentException> {
                value.validCarName()
            }
        assertEquals(expectedMessage, result.message)
    }

    @Test
    fun `자동차 이름이 빈 값일 때 예외 발생`() {
        val value = ""
        val expectedMessage = "[ERROR] 자동차 이름을 다시 입력해주세요."
        val result =
            assertThrows<IllegalArgumentException> {
                value.validCarName()
            }
        assertEquals(expectedMessage, result.message)
    }

    @Test
    fun `자동차 이름의 길이가 5자가 초과일 때 예외 발생`() {
        val value = "ascdef"
        val expectedMessage = "[ERROR] 자동차 이름을 다시 입력해주세요."
        val result =
            assertThrows<IllegalArgumentException> {
                value.validCarName()
            }
        assertEquals(expectedMessage, result.message)
    }

    @Test
    fun `시도횟수가 빈 값일 때 예외 발생`() {
        val value = ""
        val expectedMessage = "[ERROR] 시도횟수를 다시 입력해주세요."
        val result =
            assertThrows<IllegalArgumentException> {
                value.validTryCount()
            }
        assertEquals(expectedMessage, result.message)
    }

    @Test
    fun `시도횟수가 올바르지 않을 때 예외 발생`() {
        val value = "asc"
        val expectedMessage = "[ERROR] 시도횟수를 다시 입력해주세요."
        val result =
            assertThrows<IllegalArgumentException> {
                value.validTryCount()
            }
        assertEquals(expectedMessage, result.message)
    }

    @Test
    fun `랜덤 숫자의 범위가 올바르지 않을 때 예외 발생`() {
        val value = GenerateRandomNumber().randomNumber()
        val expected = true
        val result = value in 0..9

        assertEquals(expected, result)
    }
}

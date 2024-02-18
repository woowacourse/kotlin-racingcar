package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.Winner

class WinnerTest {
    @DisplayName("우승자 판단 테스트 - 우승자일 때")
    @Test
    fun judgeWinners() {
        val car = Car("hye", 3)
        val maxPosition = 3
        val expectedResult = "hye"
        val result = Winner().judge(
            car,
            maxPosition
        )

        assertEquals(expectedResult, result)
    }

    @DisplayName("우승자 판단 테스트 - 우승자 아닐 때")
    @Test
    fun winners() {
        val car = Car("hye", 1)
        val maxPosition = 3
        val expectedResult = null
        val result = Winner().judge(
            car,
            maxPosition
        )

        assertEquals(expectedResult, result)
    }
}

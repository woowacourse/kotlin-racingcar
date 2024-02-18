package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.Winner

class WinnerTest {
    @DisplayName("우승자 판단 테스트")
    @Test
    fun judgeWinners() {
        val car = Car("hye", 3)
        val maxPosition = 3
        val expectedResult = "hye"
        val result = Winner().judgeWinners(
            car,
            maxPosition
        )

        assertEquals(expectedResult, result)
    }
}

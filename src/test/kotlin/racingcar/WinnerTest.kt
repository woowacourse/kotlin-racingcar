package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.controller.Race
import racingcar.model.Car

class WinnerTest {
    private val race = Race()

    @DisplayName("최종 우승자 확인")
    @Test
    fun checkWinners() {
        val cars =
            listOf(
                Car("crong", 5),
                Car("hena", 2),
                Car("pang", 3),
            )
        val expectedResult = listOf("crong")
        val winners = race.getWinners(cars)

        assertEquals(expectedResult, winners)
    }
}

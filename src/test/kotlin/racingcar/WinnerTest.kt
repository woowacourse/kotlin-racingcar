package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.controller.Race
import racingcar.model.Car

class WinnerTest {
    private val race = Race()

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

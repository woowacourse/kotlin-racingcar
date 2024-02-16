package racingcar.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import racingcar.domain.Car

class WinnerServiceTest {

    @Test
    fun testFindWinners() {
        val cars = listOf(
            Car("car0"),
            Car("car1"),
            Car("car2")
        )
        cars[0].move(9)
        cars[0].move(9)
        cars[0].move(9)
        cars[0].move(9)
        cars[1].move(9)
        cars[1].move(9)

        val winnerService = WinnerService()
        val winners = winnerService.findWinners(cars)
        assertTrue(winners.equals(listOf("car0")))
    }
}

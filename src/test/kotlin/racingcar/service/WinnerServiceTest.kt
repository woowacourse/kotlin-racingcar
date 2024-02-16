package racingcar.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import racingcar.constant.MoveConstant
import racingcar.domain.Car

class WinnerServiceTest {

    @Test
    fun testFindWinners() {
        val cars = listOf(
            Car("car0"),
            Car("car1"),
            Car("car2")
        )
        repeat(3) {
            cars[0].move(MoveConstant.FORWARD_NUMBER)

        }
        repeat(2) {
            cars[1].move(MoveConstant.FORWARD_NUMBER)
        }

        val winnerService = WinnerService()
        val winners = winnerService.findWinners(cars)
        assertTrue(winners.equals(listOf("car0")))
    }
}

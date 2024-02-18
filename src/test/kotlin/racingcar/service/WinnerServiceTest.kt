package racingcar.service

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.constant.MoveConstant
import racingcar.domain.Car

class WinnerServiceTest {
    @Test
    fun `위치가 3,2,0인 자동차들이 있을 경우, 우승자는 위치가 3인 자동차이다`() {
        val cars =
            listOf(
                Car("car0"),
                Car("car1"),
                Car("car2"),
            )
        repeat(3) {
            cars[0].move(MoveConstant.FORWARD_NUMBER)
        }
        repeat(2) {
            cars[1].move(MoveConstant.FORWARD_NUMBER)
        }

        val winnerService = WinnerService()
        val winners = winnerService.findWinners(cars)

        assertTrue(winners == listOf("car0"))
    }
}

package racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import racingcar.domain.Car

class WinnerServiceTest {
    @Test
    fun `우승자는 여러 명일 수 있습니다`() {
        val cars: List<Car> = listOf(
            Car("hodu"),
            Car("happy"),
            Car("cat")
        )
        cars[0].move(5)
        cars[1].move(5)
        assertThat(WinnerService.findWinners(cars)).isEqualTo(listOf("hodu", "happy"))
    }
}

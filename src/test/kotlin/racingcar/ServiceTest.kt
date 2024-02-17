package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.service.ForwardService
import racingcar.service.RandomGenerator
import racingcar.service.WinnerService

class ServiceTest {
    private val forwardService = ForwardService()
    private val winnerService = WinnerService()

    /** RandomGenerator Test */
    @Test
    fun `생성한 랜덤값이 제한 범위에 포함되는지 확인한다`() {
        val randomGenerator = RandomGenerator()
        repeat(100) {
            assertThat(randomGenerator.generate())
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9)
        }
    }

    /** ForwardService Test */
    @Test
    fun `랜덤 숫자가 전진 기준과 같거나 큰 경우 전진하는지 확인한다`() {
        // given
        val car = Car("olive")

        // when
        forwardService.tryForwardCar(car, 4)

        // then
        assertThat(car.forwardCount).isEqualTo(1)
    }

    @Test
    fun `랜덤 숫자가 전진 기준보다 작은 경우 전진하지 않는지 확인한다`() {
        // given
        val car = Car("olive")

        // when
        forwardService.tryForwardCar(car, 0)

        // then
        assertThat(car.forwardCount).isEqualTo(0)
    }

    /** WinnerService Test */
    @Test
    fun `단독 우승자를 확인한다`() {
        // given
        val cars = listOf(
            Car("olive"),
            Car("chae").apply { forward() }
        )

        // when
        val winners = winnerService.getWinners(cars)

        // then
        assertThat(winners[0].toString()).isEqualTo("chae")
    }

    @Test
    fun `공동 우승자를 확인한다`() {
        // given
        val cars = listOf(
            Car("olive").apply { forward() },
            Car("chae").apply { forward() }
        )

        // when
        val winners = winnerService.getWinners(cars)

        // then
        assertThat(winners.map { it.toString() })
            .contains("olive", "chae")
    }
}

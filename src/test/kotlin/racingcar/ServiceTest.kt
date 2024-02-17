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
    fun `생성한 랜덤값의 범위가 0부터 9인지 확인한다`() {
        val randomGenerator = RandomGenerator()
        assertThat(randomGenerator.generate())
            .isGreaterThanOrEqualTo(0)
            .isLessThanOrEqualTo(9)
    }

    /** ForwardService Test */
    @Test
    fun `4 이상일 경우 전진하는지 확인한다`() {
        // given
        val car = Car("olive")
        val initialPosition = car.position

        // when
        forwardService.tryForwardCar(car, 4)

        // then
        assertThat(car.position).isEqualTo(initialPosition + 1)
    }

    @Test
    fun `4 미만일 경우 전진하는지 확인한다`() {
        // given
        val car1 = Car("olive")
        val car2 = Car("chae")

        // when
        forwardService.tryForwardCar(car1, 0)

        // then
        assertThat(car1.compareTo(car2)).isEqualTo(0)
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

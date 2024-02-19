package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.service.ForwardNumberGenerator
import racingcar.service.ForwardService
import racingcar.service.RacingGame
import racingcar.service.RandomForwardNumberGenerator

class ServiceTest {
    /** ForwardService Test */
    @Test
    fun `랜덤 숫자가 전진 기준과 같거나 큰 경우 전진하는지 확인한다`() {
        // given
        val car = Car("olive")
        val testForwardNumberGenerator =
            object : ForwardNumberGenerator {
                override fun generate() = 4
            }

        // when
        ForwardService.tryForwardCar(car, testForwardNumberGenerator)

        // then
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `랜덤 숫자가 전진 기준보다 작은 경우 전진하지 않는지 확인한다`() {
        // given
        val car = Car("olive")
        val testForwardNumberGenerator =
            object : ForwardNumberGenerator {
                override fun generate() = 0
            }

        // when
        ForwardService.tryForwardCar(car, testForwardNumberGenerator)

        // then
        assertThat(car.position).isEqualTo(0)
    }

    /** WinnerService Test */
    @Test
    fun `단독 우승자를 확인한다`() {
        // given
        val cars =
            listOf(
                Car("olive"),
                Car("chae").apply { forward() },
            )
        val racingGame = RacingGame(cars, RandomForwardNumberGenerator)

        // when
        val winners = racingGame.getWinners()

        // then
        assertThat(winners[0].toString()).isEqualTo("chae")
    }

    @Test
    fun `공동 우승자를 확인한다`() {
        // given
        val cars =
            listOf(
                Car("olive").apply { forward() },
                Car("chae").apply { forward() },
            )
        val racingGame = RacingGame(cars, RandomForwardNumberGenerator)

        // when
        val winners = racingGame.getWinners()

        // then
        assertThat(winners.map { it.toString() })
            .contains("olive", "chae")
    }
}

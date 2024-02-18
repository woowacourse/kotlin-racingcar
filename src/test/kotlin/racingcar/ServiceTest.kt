package racingcar

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.constants.GameConstants
import racingcar.model.Car
import racingcar.service.RacingService
import racingcar.service.RandomGenerator
import racingcar.service.WinnerService

class ServiceTest {
    private val winnerService = WinnerService()
    private lateinit var racingService: RacingService
    private val randomGenerator = mockk<RandomGenerator>()

    @BeforeEach
    fun setUp() {
        racingService = RacingService(randomGenerator)
    }

    /** RandomGenerator Test */
    @Test
    fun `생성한 랜덤값의 범위가 0부터 9인지 확인한다`() {
        val randomGenerator = RandomGenerator()
        assertThat(randomGenerator.generate())
            .isGreaterThanOrEqualTo(0)
            .isLessThanOrEqualTo(9)
    }

    /** RacingService Test */
    @Test
    fun `랜덤 값이 전진 조건을 충족할 때 자동차가 전진한다`() {
        // given
        val cars = listOf(Car("Olive"))
        every { randomGenerator.generate() } returns GameConstants.FORWARD_FLAG_NUMBER

        // when
        val resultCars = racingService.startRace(cars)

        // then
        assertThat(resultCars.first().position).isEqualTo(1)
    }

    @Test
    fun `랜덤 값이 전진 조건을 충족하지 않을 때 자동차가 전진하지 않는다`() {
        // given
        val cars = listOf(Car("Olive"))
        every { randomGenerator.generate() } returns GameConstants.FORWARD_FLAG_NUMBER - 1

        // when
        val resultCars = racingService.startRace(cars)

        // then
        assertThat(resultCars.first().position).isEqualTo(0)
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

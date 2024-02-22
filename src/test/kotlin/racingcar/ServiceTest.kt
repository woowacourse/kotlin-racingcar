package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.service.RacingService
import racingcar.service.RandomGenerator
import racingcar.service.WinnerService
import racingcar.utils.NumberGenerator

class ServiceTest {
    private val winnerService = WinnerService()
    private lateinit var racingService: RacingService

    /** RandomGenerator Test */
    @Test
    fun `생성한 랜덤값의 범위가 0부터 9인지 확인한다`() {
        val randomGenerator = RandomGenerator()
        assertThat(randomGenerator.generate())
            .isGreaterThanOrEqualTo(0)
            .isLessThanOrEqualTo(9)
    }

    /** RacingService Test */
    class TestNumberGenerator(private val testValue: Int) : NumberGenerator {
        override fun generate() = testValue
    }

    @Test
    fun `랜덤 값이 전진 조건을 충족할 때 자동차가 전진한다`() {
        // given
        val testValue = 5 // 전진 조건
        val testNumberGenerator = TestNumberGenerator(testValue)
        val racingService = RacingService(testNumberGenerator)
        val cars = listOf(Car("Olive"))

        // when
        val resultCars = racingService.startRace(cars)

        // then
        assertThat(resultCars.first().position).isEqualTo(1) //전진
    }

    @Test
    fun `랜덤 값이 전진 조건을 충족하지 않을 때 자동차가 전진하지 않는다`() {
        // given
        val testValue = 0 // 전진하지 않는 조건
        val testNumberGenerator = TestNumberGenerator(testValue)
        val racingService = RacingService(testNumberGenerator)
        val cars = listOf(Car("Olive"))

        // when
        val resultCars = racingService.startRace(cars)

        // then
        assertThat(resultCars.first().position).isEqualTo(0) //정지
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
        assertThat(winners[0].name).isEqualTo("chae")
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
        assertThat(winners.map { it.name })
            .contains("olive", "chae")
    }
}

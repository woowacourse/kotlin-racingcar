package racingcar.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.mockito.Mockito
import racingcar.model.car.CarDto
import racingcar.model.car.CarsDto
import racingcar.model.round.RoundDto
import racingcar.utils.random.MovementProbabilityGenerator
import racingcar.utils.random.MovementProbabilityGenerator.Companion.START_RANDOM_MOVEMENT_PROBABILITY
import racingcar.utils.random.RandomGenerator
import java.util.stream.Stream

internal class RacingServiceTest {
    private lateinit var racingService: RacingService
    private lateinit var movementProbabilityGenerator: RandomGenerator

    @BeforeEach
    fun beforeEach() {
        val cars = CarsDto(
            listOf("부나", "우기", "핑구", "수달", "스캇", "써니").map { CarDto(it) }
        )

        movementProbabilityGenerator = Mockito.mock(MovementProbabilityGenerator::class.java)
        Mockito.`when`(movementProbabilityGenerator.generate()).thenReturn(ABSOLUTE_MOVE_PROBABILITY)

        racingService = RacingService(cars, movementProbabilityGenerator)
    }

    @ParameterizedTest
    @MethodSource("provideRounds")
    fun `Round가 주어졌을 때, runAllRounds시, Round 횟수만큼 레이싱을 진행한다`(round: RoundDto) {
        var actualRoundCount = 0
        racingService.runAllRounds(round) {
            ++actualRoundCount
        }

        assertEquals(round.count, actualRoundCount)
    }

    companion object {
        private const val ABSOLUTE_MOVE_PROBABILITY = START_RANDOM_MOVEMENT_PROBABILITY

        @JvmStatic
        fun provideRounds(): Stream<Arguments> = Stream.of(
            Arguments.of(RoundDto(2)),
            Arguments.of(RoundDto(5)),
            Arguments.of(RoundDto(10)),
        )
    }
}

package racingcar.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.dto.car.CarDto
import racingcar.dto.car.CarsDto
import racingcar.dto.round.RoundDto
import racingcar.model.car.move.condition.CarMoveCondition
import racingcar.model.car.move.condition.FakeCarRandomMoveCondition
import java.util.stream.Stream

internal class RacingServiceTest {
    private lateinit var racingService: RacingService
    private lateinit var carMoveCondition: CarMoveCondition

    @BeforeEach
    fun beforeEach() {
        val cars = CarsDto(
            listOf("부나", "우기", "핑구", "수달", "스캇", "써니").map { CarDto(it) }
        )

        carMoveCondition = FakeCarRandomMoveCondition.FakeForSuccess()
        racingService = RacingService(cars, carMoveCondition)
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
        @JvmStatic
        fun provideRounds(): Stream<Arguments> = Stream.of(
            Arguments.of(RoundDto(2)),
            Arguments.of(RoundDto(5)),
            Arguments.of(RoundDto(10)),
        )
    }
}

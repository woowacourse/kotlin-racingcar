package racingcar.service

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.provider.Arguments
import racingcar.model.car.Car
import java.util.stream.Stream

internal class RacingServiceTest {

    private lateinit var racingService: RacingService

    @BeforeEach
    fun beforeEach() {
        val carNames = listOf("부나", "우기", "핑구", "수달", "스캇", "써니")
        this.racingService = RacingService(carNames)
    }

    // @ParameterizedTest
    // @MethodSource("provideCarsForHappyCase")
    // fun `각 자동차가 moveCount만큼 이동한 경우, 우승자 산출시, expectedWinnersCount와 동일해야 한다`(
    //     cars: List<Car>,
    //     moveCounts: List<Int>,
    //     expectedWinnersCount: Int
    // ) {
    //     racingService.insertCars(cars)
    //     racingService.getAll().forEachIndexed { index, car ->
    //         repeat(moveCounts[index]) { car.move(ABSOLUTE_MOVE_CONDITION) }
    //     }
    //
    //     val realWinnersCount = racingService.getWinners().size
    //
    //     assertEquals(realWinnersCount, expectedWinnersCount)
    // }
    //
    // @ParameterizedTest
    // @MethodSource("provideCarsForExceptionCase")
    // fun `각 자동차가 moveCount만큼 이동한 경우, 우승자 산출시 expectedWinnersCount와 다르면, IllegalArgumentException가 발생한다`(
    //     cars: List<Car>,
    //     moveCounts: List<Int>,
    //     expectedWinnersCount: Int
    // ) {
    //     racingService.insertCars(cars)
    //     racingService.getAll().forEachIndexed { index, car ->
    //         repeat(moveCounts[index]) {
    //             car.move(ABSOLUTE_MOVE_CONDITION)
    //         }
    //     }
    //
    //     val realWinnersCount = racingService.getWinners().size
    //
    //     assertNotEquals(realWinnersCount, expectedWinnersCount)
    // }

    companion object {
        private const val ABSOLUTE_MOVE_CONDITION = 10

        @JvmStatic
        fun provideCarsForHappyCase(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        Car("sooda"),
                        Car("buna"),
                        Car("sunny"),
                    ),
                    listOf(7, 6, 2),
                    1
                ),
                Arguments.of(
                    listOf(
                        Car("sooda"),
                        Car("buna"),
                        Car("sunny"),
                    ),
                    listOf(7, 7, 7),
                    3
                ),
                Arguments.of(
                    listOf(
                        Car("sooda"),
                        Car("buna"),
                        Car("sunny"),
                    ),
                    listOf(0, 0, 0),
                    3
                ),
            )
        }

        @JvmStatic
        fun provideCarsForExceptionCase(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        Car("sooda"),
                        Car("buna"),
                        Car("sunny"),
                    ),
                    listOf(7, 6, 2),
                    2
                ),
                Arguments.of(
                    listOf(
                        Car("sooda"),
                        Car("buna"),
                        Car("sunny"),
                    ),
                    listOf(7, 2, 7),
                    1
                ),
                Arguments.of(
                    listOf(
                        Car("sooda"),
                        Car("buna"),
                        Car("sunny"),
                    ),
                    listOf(0, 0, 0),
                    0
                ),
                Arguments.of(
                    listOf(
                        Car("sooda"),
                        Car("buna"),
                        Car("sunny"),
                    ),
                    listOf(1, 2, 3),
                    4
                ),
            )
        }
    }
}

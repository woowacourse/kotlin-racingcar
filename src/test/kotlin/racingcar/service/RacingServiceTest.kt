package racingcar.service

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car
import java.util.stream.Stream
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

internal class RacingServiceTest {

    private lateinit var racingService: RacingService

    @BeforeEach
    fun beforeEach() {
        this.racingService = RacingService()
    }

    @ParameterizedTest
    @ValueSource(strings = ["buna", "sooda"])
    fun `공백이 아닌 1글자 이상 5글자 이하의 이름인 경우, createCar시, 예외가 발생하지 않는다`(carName: String) {
        assertDoesNotThrow {
            racingService.createCar(carName)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["soooodal", "buuuuuuuna", ""])
    fun `공백이나 5글자이상의 이름인 경우, createCar시 , IllegalArgumentException가 발생한다`(carName: String) {
        assertThrows<IllegalArgumentException> {
            racingService.createCar(carName)
        }
    }

    @ParameterizedTest
    @MethodSource("provideCarsForHappyCase")
    fun `각 자동차가 moveCount만큼 이동한 경우, 우승자 산출시, expectedWinnersCount와 동일하다`(
        cars: List<Car>,
        moveCounts: List<Int>,
        expectedWinnersCount: Int
    ) {
        cars.forEachIndexed { index, car ->
            repeat(moveCounts[index]) {
                car.move()
            }
        }

        val realWinnersCount = racingService.getWinners(cars).size

        assertEquals(realWinnersCount, expectedWinnersCount)
    }

    @ParameterizedTest
    @MethodSource("provideCarsForExceptionCase")
    fun `각 자동차가 moveCount만큼 이동한 경우, 우승자 산출시 expectedWinnersCount와 다르면, IllegalArgumentException가 발생한다`(
        cars: List<Car>,
        moveCounts: List<Int>,
        expectedWinnersCount: Int
    ) {
        cars.forEachIndexed { index, car ->
            repeat(moveCounts[index]) {
                car.move()
            }
        }

        val realWinnersCount = racingService.getWinners(cars).size

        assertNotEquals(realWinnersCount, expectedWinnersCount)
    }

    companion object {
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

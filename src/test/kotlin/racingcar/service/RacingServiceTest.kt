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
    fun `자동차 객체 생성 노말 테스트`(carName: String) {
        assertDoesNotThrow {
            racingService.createCar(carName)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["soooodal", "buuuuuuuna", ""])
    fun `자동차 객체 생성 예외 테스트`(carName: String) {
        assertThrows<IllegalArgumentException> {
            racingService.createCar(carName)
        }
    }

    @ParameterizedTest
    @MethodSource("provideCarsForHappyCase")
    fun `최종 우승자 산출 노말 테스트`(cars: List<Car>, moveCounts: List<Int>, expectedWinnersCount: Int) {
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
    fun `최종 우승자 산출 예외 테스트`(cars: List<Car>, moveCounts: List<Int>, expectedWinnersCount: Int) {
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

package racingcar.model.car

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.model.car.move.condition.CarMoveCondition
import racingcar.model.car.move.condition.CarRandomMoveCondition
import java.util.stream.Stream

internal class CarsTest {
    private lateinit var cars: Cars
    private lateinit var carRandomMoveFailureCondition: CarMoveCondition
    private lateinit var carRandomMoveSuccessiveCondition: CarMoveCondition

    @BeforeEach
    fun setUp() {
        cars = Cars(
            listOf(
                Car("buna"),
                Car("sooda"),
                Car("sunny")
            )
        )

        carRandomMoveFailureCondition = CarRandomMoveCondition.FakeForFailed()
        carRandomMoveSuccessiveCondition = CarRandomMoveCondition.FakeForSuccess()
    }

    @ParameterizedTest
    @MethodSource("provideDistinctCarsForName")
    fun `중복되지 않은 이름의 자동차가 주어지면, Cars 객체 생성시, 예외가 발생하지 않는다`(distinctCars: List<Car>) {
        assertDoesNotThrow {
            Cars(distinctCars)
        }
    }

    @ParameterizedTest
    @MethodSource("provideDuplicatedCarsForName")
    fun `중복된 이름의 자동차가 주어지면, Cars 객체 생성시, IllegalArgumentException가 발생한다`(duplicatedCars: List<Car>) {
        assertThrows<IllegalArgumentException> {
            Cars(duplicatedCars)
        }
    }

    @Test
    fun `이동을 성공하는 확률이 주어졌을 때, moveAllRandomly시, 모든 자동차의 position이 1씩 증가한다`() {
        cars.moveAll(carRandomMoveSuccessiveCondition)

        cars.forEach { car ->
            assertEquals(ONE_STEP, car.position)
        }
    }

    @Test
    fun `이동을 실패하는 확률이 주어졌을 때, moveAllRandomly시, 모든 자동차의 position이 증가하지 않는다`() {
        cars.moveAll(carRandomMoveFailureCondition)

        cars.forEach { car ->
            assertNotEquals(ONE_STEP, car.position)
        }
    }

    @ParameterizedTest
    @MethodSource("provideCarsWithSamePositionCarsSize")
    fun `position이 같은 Car가 expected만큼 주어졌을 때, getWinners시, winners 객체의 길이는 expected와 같다`(cars: Cars, expected: Int) {
        val winners = cars.getWinners()

        assertEquals(expected, winners.size)
    }

    companion object {
        private const val ONE_STEP = 1

        @JvmStatic
        fun provideDistinctCarsForName(): Stream<Arguments> = Stream.of(
            Arguments.of(
                listOf(
                    Car("buna"),
                    Car("sooda"),
                    Car("sunny")
                )
            )
        )

        @JvmStatic
        fun provideDuplicatedCarsForName(): Stream<Arguments> = Stream.of(
            Arguments.of(
                listOf(
                    Car("buna"),
                    Car("buna"),
                    Car("sunny")
                )
            )
        )

        @JvmStatic
        fun provideCarsWithSamePositionCarsSize(): Stream<Arguments> = Stream.of(
            Arguments.of(
                Cars(
                    listOf(
                        Car("buna", 10),
                        Car("sooda", 5),
                        Car("sunny", 5)
                    )
                ),
                1
            ),
            Arguments.of(
                Cars(
                    listOf(
                        Car("buna", 3),
                        Car("sooda", 10),
                        Car("sunny", 0)
                    )
                ),
                1
            ),
            Arguments.of(
                Cars(
                    listOf(
                        Car("buna", 3),
                        Car("sooda", 3),
                        Car("sunny", 10)
                    )
                ),
                1
            ),
            Arguments.of(
                Cars(
                    listOf(
                        Car("buna", 10),
                        Car("sooda", 10),
                        Car("sunny", 5)
                    )
                ),
                2
            ),
            Arguments.of(
                Cars(
                    listOf(
                        Car("buna", 3),
                        Car("sooda", 10),
                        Car("sunny", 10)
                    )
                ),
                2
            ),
            Arguments.of(
                Cars(
                    listOf(
                        Car("buna", 1),
                        Car("sooda", 0),
                        Car("sunny", 1)
                    )
                ),
                2
            ),
            Arguments.of(
                Cars(
                    listOf(
                        Car("buna", 10),
                        Car("sooda", 10),
                        Car("sunny", 10)
                    )
                ),
                3
            ),
            Arguments.of(
                Cars(
                    listOf(
                        Car("buna", 5),
                        Car("sooda", 5),
                        Car("sunny", 5)
                    )
                ),
                3
            ),
            Arguments.of(
                Cars(
                    listOf(
                        Car("buna", 0),
                        Car("sooda", 0),
                        Car("sunny", 0)
                    )
                ),
                3
            ),
        )
    }
}

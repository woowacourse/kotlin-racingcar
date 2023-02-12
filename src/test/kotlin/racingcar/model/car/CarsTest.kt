package racingcar.model.car

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.mockito.Mockito.spy
import racingcar.utils.random.MovementProbabilityGenerator
import racingcar.utils.random.RandomGenerator
import java.util.stream.Stream

internal class CarsTest {
    private lateinit var carsMock: Cars
    private lateinit var movementProbabilityGenerator: RandomGenerator

    @BeforeEach
    fun setUp() {
        carsMock = spy(
            Cars(
                listOf(
                    Car("buna"),
                    Car("sooda"),
                    Car("sunny")
                )
            )
        )
        movementProbabilityGenerator = MovementProbabilityGenerator()
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

    companion object {
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
    }
}

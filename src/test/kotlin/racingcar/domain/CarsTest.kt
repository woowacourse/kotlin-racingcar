package racingcar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class CarsTest {

    @Test
    fun `자동차 이름이 중복되지 않을 때 에러가 발생하지 않습니다`() {
        assertDoesNotThrow {
            val cars = listOf(
                Car("otter"),
                Car("buna")
            )

            Cars(cars)
        }
    }

    @Test
    fun `자동차 이름이 중복될 때 에러가 발생합니다`() {
        assertThrows<IllegalArgumentException> {
            val cars = listOf(
                Car("otter"),
                Car("otter")
            )

            Cars(cars)
        }
    }

    @ParameterizedTest
    @MethodSource("provideGetWinnersHappyCase")
    fun `산출된 우승자 리스트의 개수가 일치합니다`(cars: Cars, expectedWinnersCount: Int) {
        val realWinners = cars.getWinners()
        assertEquals(realWinners.cars.size, expectedWinnersCount)
    }

    companion object {
        @JvmStatic
        fun provideGetWinnersHappyCase(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    Cars(
                        listOf(
                            Car("sooda", 7),
                            Car("buna", 6),
                            Car("sunny", 2),
                        )
                    ),
                    1
                ),
                Arguments.of(
                    Cars(
                        listOf(
                            Car("sooda", 7),
                            Car("buna", 7),
                            Car("sunny", 7),
                        )
                    ),
                    3
                )
            )
        }
    }
}

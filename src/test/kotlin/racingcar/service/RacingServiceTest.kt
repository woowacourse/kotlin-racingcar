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

internal class RacingServiceTest {

    private lateinit var racingService: RacingService

    @BeforeEach
    fun beforeEach() {
        this.racingService = RacingService()
    }

    // todo isMove test

    @ParameterizedTest
    @ValueSource(strings = ["buna", "sooda"])
    fun `자동차의 이름이 규칙을 따를 때 객체를 생성합니다`(carName: String) {
        assertDoesNotThrow {
            racingService.createCar(carName)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["soooodal", "buuuuuuuna", ""])
    fun `자동차의 이름이 규칙을 따르지 않을 때 객체 생성에 에러가 발생합니다`(carName: String) {
        assertThrows<IllegalArgumentException> {
            racingService.createCar(carName)
        }
    }

    @ParameterizedTest
    @MethodSource("provideCarsForHappyCase")
    fun `각 자동차의 전진 횟수에 따른 산출된 우승자 리스트가 일치합니다`(cars: List<Car>, expectedWinnersCount: Int) {
        val realWinnersCount = racingService.getWinners(cars).size
        assertEquals(realWinnersCount, expectedWinnersCount)
    }

    companion object {
        @JvmStatic
        fun provideCarsForHappyCase(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        Car("sooda", 7),
                        Car("buna", 6),
                        Car("sunny", 2),
                    ),
                    1
                ),
                Arguments.of(
                    listOf(
                        Car("sooda", 7),
                        Car("buna", 7),
                        Car("sunny", 7),
                    ),
                    3
                ),
                Arguments.of(
                    listOf(
                        Car("sooda", 0),
                        Car("buna", 0),
                        Car("sunny", 0),
                    ),
                    3
                ),
            )
        }
    }
}

package racingcar.service

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.CarName
import racingcar.domain.Car
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class RacingServiceTest {

    private lateinit var racingService: RacingService

    @BeforeEach
    fun beforeEach() {
        this.racingService = RacingService()
    }

    @ParameterizedTest
    @ValueSource(ints = [9, 4])
    fun `발행된 전진 확률이 4이상, 9이하일 때 isMove 메서드가 true를 반환합니다`(moveProbability: Int) {
        assertEquals(
            racingService.isMove(moveProbability),
            true
        )
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 3])
    fun `발행된 전진 확률이 0이상, 3이하일 때 isMove 메서드가 false를 반환합니다`(moveProbability: Int) {
        assertEquals(
            racingService.isMove(moveProbability),
            false
        )
    }

    @ParameterizedTest
    @MethodSource("provideCarsForHappyCase")
    fun `각 자동차의 전진 횟수에 따라 산출된 우승자 리스트가 일치합니다`(cars: List<Car>, expectedWinnersCount: Int) {
        val realWinnersCount = racingService.getWinners(cars).size
        assertEquals(realWinnersCount, expectedWinnersCount)
    }

    companion object {
        @JvmStatic
        fun provideCarsForHappyCase(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    listOf(
                        Car(CarName("sooda"), 7),
                        Car(CarName("buna"), 6),
                        Car(CarName("sunny"), 2),
                    ),
                    1
                ),
                Arguments.of(
                    listOf(
                        Car(CarName("sooda"), 7),
                        Car(CarName("buna"), 7),
                        Car(CarName("sunny"), 7),
                    ),
                    3
                ),
                Arguments.of(
                    listOf(
                        Car(CarName("sooda"), 0),
                        Car(CarName("buna"), 0),
                        Car(CarName("sunny"), 0),
                    ),
                    3
                ),
            )
        }
    }
}

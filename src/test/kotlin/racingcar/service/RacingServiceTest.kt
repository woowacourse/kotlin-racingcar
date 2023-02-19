package racingcar.service

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
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
}

package racingcar.service

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car

internal class RacingServiceTest {

    private lateinit var racingService: RacingService

    @BeforeEach
    fun beforeEach() {
        this.racingService = RacingService()
    }

    @ParameterizedTest
    @ValueSource(strings = ["buna", "sooda"])
    fun `자동차 객체 생성 해피 케이스`(carName: String) {
        assertDoesNotThrow {
            Car(carName)
        }
    }

    // TODO) Car 도메인에서 객체 생성시 검증
    /*
    @ParameterizedTest
    @ValueSource(strings = ["", "soodal", ","])
    fun `자동차 객체 생성 예외 케이스`(carName: String) {
        assertThrows<IllegalArgumentException> {
            Car(carName)
        }
    }

     */
}

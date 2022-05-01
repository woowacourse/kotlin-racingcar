package racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.KCar

private const val PROCEED_FLAG_NUMBER = 4

class KRacingServiceTest {

    private val carA = KCar("a")
    private val carB = KCar("b")
    private val carC = KCar("c")
    private val carD = KCar("d")
    private var racingService = KRacingService(listOf())

    @BeforeEach
    fun setUp() {
        racingService = KRacingService(listOf(carA, carB, carC, carD))
    }

    @Test
    @DisplayName("우승자를 판단합니다.")
    fun findWinners() {
        carA.proceed(PROCEED_FLAG_NUMBER)
        assertThat(racingService.findWinners())
            .hasSize(1)
            .contains(carA)
    }

    @Test
    @DisplayName("우승자가 중복일 경우 모두 판단합니다.")
    fun findMultiWinners() {
        carA.proceed(PROCEED_FLAG_NUMBER)
        carB.proceed(PROCEED_FLAG_NUMBER)
        assertThat(racingService.findWinners())
            .hasSize(2)
            .contains(carA, carB)
    }
}
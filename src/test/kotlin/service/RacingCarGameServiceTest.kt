package service

import model.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RacingCarGameServiceTest {

    private val racingCarGameService = RacingCarGameService()
    private val carA = Car("aa", 0)
    private val carB = Car("bb", 0)
    private val carC = Car("cc", 0)
    private val carD = Car("dd", 0)

    @Test
    @DisplayName(" \"aa,bb,cc\" 을 쉼표로 구분하여 [aa,bb,cc] 인 리스트로 반환한다. ")
    fun splitCarNames() {
        val carNames = racingCarGameService.splitCarNames("${carA.name},${carB.name},${carC.name}")
        assertThat(carNames).isEqualTo(listOf("aa", "bb", "cc"))
    }

    @Test
    @DisplayName("가장 멀리 전진한 차량들이 우승자들이다.")
    fun getMaxPositionCars() {

        repeat(3) { carA.moveForward(true) }
        repeat(3) { carB.moveForward(true) }
        carC.moveForward(true)
        carD.moveForward(true)

        val carsInfo = listOf(carA, carB, carC, carD)
        val actual = racingCarGameService.getWinners(carsInfo)
        val expect = listOf(carA, carB)
        assertThat(actual).isEqualTo(expect)
    }

    @Test
    @DisplayName("자동차들이 움직인 라운드 결과를 출력한다.")
    fun getRoundResult() {
        repeat(3) { carA.moveForward(true) }
        repeat(4) { carB.moveForward(true) }
        val carsInfo = listOf(carA, carB)
        val actual = racingCarGameService.getRoundResult(carsInfo)
        val expect = "aa : ---\nbb : ----\n"
        assertThat(actual).isEqualTo(expect)
    }

    @Test
    @DisplayName("우승자의 이름이 aa,bb 라면 최종우승자: aa,bb 로 출력한다.")
    fun getWinnersOutput() {
        repeat(5) { carA.moveForward(true) }
        repeat(6) { carB.moveForward(true) }
        repeat(6) { carC.moveForward(true) }
        repeat(4) { carD.moveForward(true) }
        val carsInfo = listOf(carA, carB, carC, carD)
        val winners = racingCarGameService.getWinners(carsInfo)
        val actual = racingCarGameService.getWinnersOutput(winners)
        val expect = "최종 우승자: bb, cc"
        assertThat(actual).isEqualTo(expect)
    }
}

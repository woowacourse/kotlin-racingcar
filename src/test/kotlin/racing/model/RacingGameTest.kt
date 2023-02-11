package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingGameTest {

    private val racingGame = RacingGame(listOf(Car("woni"), Car("pobi"), Car("jason")))

    @Test
    fun `getCars()로 반환이 되는지 확인`() {
        val cars = racingGame.cars.map { car: Car -> car.name }
        val expectation = listOf(Car("woni"), Car("pobi"), Car("jason")).map { car: Car -> car.name }
        assertThat(cars).isEqualTo(expectation)
    }

    @Test
    fun `우승자가 한명일 때`() {
        racingGame.cars[WONI].move(PROGRESS)
        assertThat(racingGame.getWinnerNames()).isEqualTo(listOf("woni"))
    }

    @Test
    fun `우승자가 두 명일 때`() {
        racingGame.cars[WONI].move(PROGRESS)
        racingGame.cars[POBI].move(PROGRESS)
        assertThat(racingGame.getWinnerNames()).isEqualTo(listOf("woni", "pobi"))
    }

    companion object {
        private const val PROGRESS = 9
        private const val WONI = 0
        private const val POBI = 1
    }
}

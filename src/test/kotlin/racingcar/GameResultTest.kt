package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class GameResultTest {

    @Test
    fun pickWinners() {
        val cars = createCars()
        cars.moveAll(listOf(3, 4, 4))

        val result = GameResult(cars)
        val winners = result.pickWinners()

        assertAll(
            { assertThat(winners).hasSize(2) },
            { assertThat(winners[0].name).isEqualTo("jae") },
            { assertThat(winners[1].name).isEqualTo("choi") }
        )
    }

    private fun createCars() = Cars.of(listOf("huni", "jae", "choi"))
}

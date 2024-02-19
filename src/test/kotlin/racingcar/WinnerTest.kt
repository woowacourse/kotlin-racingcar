package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.Winner

class WinnerTest {
    private val winner = Winner()

    @Test
    fun checkWinners() {
        val cars =
            listOf(
                Car("crong", 5),
                Car("hena", 2),
                Car("pang", 3),
            )
        val expectedResult = mutableListOf("crong")

        val actualResult = mutableListOf<String>()
        cars.forEach { car ->
            winner.judgeWinners(car, 5, actualResult)
        }

        assertThat(actualResult).isEqualTo(expectedResult)
    }
}

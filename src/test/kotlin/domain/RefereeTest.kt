package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import util.TestCarFactory

internal class RefereeTest {

    @Test
    fun `우승자 선발 테스트`() {
        val names = listOf("세훈", "용민", "제이슨", "제임스", "레아")
        val randomNumbers = listOf(1, 2, 5, 3, 6)
        val expectedWinners = listOf("제이슨", "레아")
        val cars = TestCarFactory.makeCars(names, randomNumbers)

        cars.forEach { it.decideCarMovement() }
        val actualResult = Referee.judgeWinner(cars)

        assertThat(actualResult).isEqualTo(expectedWinners)
    }
}

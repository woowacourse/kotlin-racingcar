package domain

import data.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarRacingGameTest {

    @Test
    fun `우승자 정하기`() {
        val cars = listOf(Car(NAME1, WINNER_POSITION), Car(NAME2, LOSER_POSITION))
        assertThat(CarRacingGame().decideWinner(cars)).isEqualTo(listOf(NAME1))
    }

    @Test
    fun `우승자가 여러 명일 경우`() {
        val cars = listOf(Car(NAME1, WINNER_POSITION), Car(NAME2, WINNER_POSITION))
        assertThat(CarRacingGame().decideWinner(cars)).isEqualTo(listOf(NAME1, NAME2))
    }

    companion object {
        const val NAME1 = "우기"
        const val NAME2 = "핑구"
        const val WINNER_POSITION = 3
        const val LOSER_POSITION = 0
    }
}

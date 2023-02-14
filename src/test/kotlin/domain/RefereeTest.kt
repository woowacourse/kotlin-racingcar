package domain

import model.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RefereeTest {

    private val referee: Referee = Referee()

    @Test
    fun `우승자 정하기`() {
        val cars = listOf(Car("우기", 3), Car("핑구", 0))

        val winner = referee.decideWinner(cars)
        val result = listOf("우기")

        assertThat(winner).isEqualTo(result)
    }

    @Test
    fun `우승자가 여러 명일 경우`() {
        val cars = listOf(Car("우기", 3), Car("핑구", 3))

        val winner = referee.decideWinner(cars)
        val result = listOf("우기", "핑구")

        assertThat(winner).isEqualTo(result)
    }
}

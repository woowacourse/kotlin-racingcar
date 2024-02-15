package racingcar.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.model.Car

class FinalWinnerTest {
    private lateinit var finalWinner: FinalWinner

    @BeforeEach
    fun setUp() {
        finalWinner = FinalWinner()
    }

    @Test
    fun `최종 우승자 판정이 제대로 이루어지는지`() {
        val result = finalWinner.decideWinner(listOf(Car("a", "---"), Car("b", "--")))

        assertThat(result).isEqualTo(listOf("a"))
    }

    @Test
    fun `최종 우승자가 두명일 경우 우승자 판정이 제대로 이루어지는지`() {
        val result = finalWinner.decideWinner(listOf(Car("a", "---"), Car("b", "---")))

        assertThat(result).isEqualTo(listOf("a", "b"))
    }
}

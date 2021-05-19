package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class RacingCarGameTest {

    @DisplayName("자동차 게임을 진행한다")
    @Test
    internal fun race() {
        //given
        val cars = Cars(listOf(Car("Benz"), Car("Kia")))
        val tryNumber = 2
        val racingCarGame = RacingCarGame(cars, tryNumber)

        //when
        val result = racingCarGame.race()

        //then
        assertAll(
            { assertThat(result).hasSize(tryNumber) },
            { assertThat(result[0].cars).hasSize(2) },
            { assertThat(result[0].cars[0].position).isEqualTo(1) },
            { assertThat(result[0].cars[1].position).isEqualTo(1) },
            { assertThat(result[1].cars).hasSize(2) },
            { assertThat(result[1].cars[0].position).isEqualTo(2) },
            { assertThat(result[1].cars[1].position).isEqualTo(2) }
        )
    }

    @DisplayName("우승자들을 찾는디")
    @Test
    internal fun `findWinner`() {
        //given
        val cars = Cars(listOf(Car("Benz", 4), Car("Kia"), Car("ROKI", 3)))
        val tryNumber = 4
        val racingCarGame = RacingCarGame(cars, tryNumber)

        //when
        val winners = racingCarGame.findWinners()

        //then
        assertAll(
            { assertThat(winners).hasSize(1)},
            { assertThat(winners[0].name).isEqualTo("Benz")},
            { assertThat(winners[0].position).isEqualTo(4)}
        )
    }
}

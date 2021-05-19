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
        val cars = Cars(listOf(Car(), Car()))
        val tryNumber = 2
        val racingCarGame = RacingCarGame(cars, tryNumber)

        //when
        val result = racingCarGame.race()

        //then
        assertAll(
            { assertThat(result).hasSize(tryNumber) },
            { assertThat(result[0].cars).hasSize(2) },
            { assertThat(result[0].cars[0].position).isBetween(0, 2) },
            { assertThat(result[0].cars[1].position).isBetween(0, 2) },
            { assertThat(result[1].cars).hasSize(2) },
            { assertThat(result[1].cars[0].position).isBetween(0, 2) },
            { assertThat(result[1].cars[1].position).isBetween(0, 2) }
        )
    }
}

package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class RacingCarGameTest {

    @DisplayName("자동차 게임을 진행한다")
    @Test
    internal fun race() {
        // given
        val cars = Cars(listOf(Car("Benz"), Car("Kia")))
        val tryNumber = 2
        val racingCarGame = RacingCarGame(cars, tryNumber)

        // when
        val result = racingCarGame.race(object : MoveStrategy {
            override fun move(): Boolean {
                return true
            }
        })

        // then
        assertAll(
            { assertThat(result.first).hasSize(tryNumber) },
            { assertThat(result.first[0].cars).hasSize(2) },
            { assertThat(result.first[0].cars[0].position).isEqualTo(1) },
            { assertThat(result.first[0].cars[1].position).isEqualTo(1) },
            { assertThat(result.first[1].cars).hasSize(2) },
            { assertThat(result.first[1].cars[0].position).isEqualTo(2) },
            { assertThat(result.first[1].cars[1].position).isEqualTo(2) },
            { assertThat(result.second).hasSize(2) }
        )
    }

}

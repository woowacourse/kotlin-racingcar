package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("자동차게임의 ")
class RacingGameTest {

    @DisplayName("시도횟수만큼 play 하면 종료 된다.")
    @Test
    fun isEndTest() {
        val cars = Cars.from(listOf("test1", "test2", "test3"))
        val trialCount = 3
        val racingGame = RacingGame(cars, trialCount)

        for (i in 1..trialCount) {
            racingGame.play { 4 }
        }

        assertThat(racingGame.isEnd()).isTrue()
    }

    @DisplayName("시도횟수만큼 play 하지 않으면 종료되지 않는다.")
    @Test
    fun isNotEndTest() {
        val cars = Cars.from(listOf("test1", "test2", "test3"))
        val trialCount = 3
        val racingGame = RacingGame(cars, trialCount)

        for (i in 1..1) {
            racingGame.play { 4 }
        }

        assertThat(racingGame.isEnd()).isFalse()
    }
}

package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class RacingGameTest {

    @ParameterizedTest
    @CsvSource(value = ["2,false", "3,true"])
    fun isOver(roundNum: Int, result: Boolean) {
        val fixedMoveStrategy = FixedMoveStrategy(listOf(2, 3, 4, 5, 1, 3, 1, 5, 6))
        val racingGame = RacingGame(listOf("a", "b", "c"), 3, fixedMoveStrategy)

        for (i in 1..roundNum) {
            racingGame.playRound()
        }

        assertThat(racingGame.isOver()).isEqualTo(result)
    }
}

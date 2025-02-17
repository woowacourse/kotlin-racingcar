package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.strategy.FakeMoveStrategy

class RacingGameTest {
    private lateinit var racingGame: RacingGame

    @Test
    @DisplayName("중복된 자동차 이름 예외 테스트")
    fun duplicateNameTest() {
        val moves = listOf(false, true)
        assertThrows<IllegalArgumentException> {
            racingGame = RacingGame(listOf("차", "차"), FakeMoveStrategy(moves))
        }
    }

    @Test
    @DisplayName("경주 횟수 예외 테스트")
    fun raceCountExcTest() {
        val moves = listOf(false, true)
        racingGame = RacingGame(listOf("0번차"), FakeMoveStrategy(moves))

        assertThrows<IllegalArgumentException> {
            racingGame.doWholeRace(0) {}
        }
    }

    @Test
    @DisplayName("우승 자동차 이름 추출 테스트")
    fun winCarNameTest() {
        val moves = listOf(false, true, false, false, true, true)
        racingGame = RacingGame(listOf("0번차", "1번차", "2번차"), FakeMoveStrategy(moves))
        racingGame.doWholeRace(2) {}

        assertThat(racingGame.getWinCarNames()).isEqualTo(listOf("1번차"))
    }
}

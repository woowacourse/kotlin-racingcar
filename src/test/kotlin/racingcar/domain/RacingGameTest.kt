package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `포지션이 가장 높은 자동차들을 반환한다`() {
        val 하티 = Car.from("하티")
        val 박스터 = Car.from("박스터")
        val cars = Cars(listOf(하티, 박스터))
        val racingGame = RacingGame(cars, 3, TestNumberGenerator(mutableListOf(4, 4)))

        racingGame.playOneRound()
        val winningCars = racingGame.findWinningCars()

        assertThat(winningCars).containsExactly(하티, 박스터)
    }

    @Test
    fun `게임이 라운드만큼 진행되면 false를 반환한다`() {
        val 하티 = Car.from("하티")
        val 박스터 = Car.from("박스터")
        val cars = Cars(listOf(하티, 박스터))
        val round = 3
        val racingGame = RacingGame(cars, round, TestNumberGenerator(mutableListOf(4, 4, 4, 4, 4, 4)))

        repeat(round) { racingGame.playOneRound() }

        assertThat(racingGame.isNotEnd()).isFalse
    }
}

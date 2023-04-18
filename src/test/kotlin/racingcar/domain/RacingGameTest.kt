package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `포지션이 가장 높은 자동차들을 반환한다`() {
        // given
        val 하티 = Car("하티")
        val 박스터 = Car("박스터")
        val cars = Cars(listOf(하티, 박스터))
        val racingGame = RacingGame(cars, 3, TestNumberGenerator(mutableListOf(4, 4)))

        // when
        racingGame.playOneRound()
        val winningCars = racingGame.findWinningCars()

        //then
        assertThat(winningCars).containsExactly(하티, 박스터)
    }

    @Test
    fun `게임이 라운드만큼 진행되면 true를 반환한다`() {
        val 하티 = Car("하티")
        val 박스터 = Car("박스터")
        val cars = Cars(listOf(하티, 박스터))
        val racingGame = RacingGame(cars, 3, TestNumberGenerator(mutableListOf(4, 4, 4, 4, 4, 4)))

        racingGame.playOneRound()
        racingGame.playOneRound()
        racingGame.playOneRound()

        assertThat(racingGame.isNotEnd()).isFalse
    }

    class TestNumberGenerator(private val numbers: MutableList<Int>) : NumberGenerator {
        override fun generate(): Int {
            return numbers.removeAt(0)
        }
    }
}


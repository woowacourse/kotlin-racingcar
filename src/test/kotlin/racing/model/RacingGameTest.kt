package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.util.NumberGenerator

internal class RacingGameTest {

    @Test
    fun `moveCars를 통해 woni를 이동 시키면 한번 움직인 결과로 woni의 postion은 1`() {
        //given
        val cars = listOf(Car("woni"), Car("pobi"), Car("jason"))

        //when
        val movedCars: List<Car> = RacingGame.moveCars(cars, OneMoveRandomNumbers())

        //then
        assertThat(movedCars[WONI].position).isEqualTo(1)
    }

    @Test
    fun `moveCars를 통해 woni, pobi를 이동 시키면 한번 움직인 결과로 woni와 pobi의 postion은 1`() {
        //given
        val cars = listOf(Car("woni"), Car("pobi"), Car("jason"))

        //when
        val movedCars: List<Car> = RacingGame.moveCars(cars, TwoMoveRandomNumbers())

        //then
        assertThat(Pair(movedCars[WONI].position, movedCars[POBI].position)).isEqualTo(Pair(1, 1))
    }

    @Test
    fun `우승자가 woni와 pobi 두 명일 때 승자 이름에 담아 반환한다`() {
        //given
        val cars = listOf(Car("woni"), Car("pobi"), Car("jason"))
        RacingGame.moveCars(cars, TwoMoveRandomNumbers())

        //when
        val winnerNames: List<String> = RacingGame.getWinnerNames(cars)

        //then
        assertThat(winnerNames).isEqualTo(listOf("woni", "pobi"))
    }

    @Test
    fun `우승자가 woni일 때 woni를 승자 이름에 담아 반환한다`() {
        //given
        val cars = listOf(Car("woni"), Car("pobi"), Car("jason"))
        RacingGame.moveCars(cars, OneMoveRandomNumbers())

        //when
        val winnerNames: List<String> = RacingGame.getWinnerNames(cars)

        //then
        assertThat(winnerNames).isEqualTo(listOf("woni"))
    }

    companion object {
        private const val PROGRESS = 9
        private const val STOP = 3
        private const val WONI = 0
        private const val POBI = 1
    }

    inner class OneMoveRandomNumbers : NumberGenerator {

        private val pattern = listOf(PROGRESS, STOP, STOP)
        private var i = 0

        override fun generate(): Int {
            return pattern[i++]
        }
    }

    inner class TwoMoveRandomNumbers : NumberGenerator {

        private val pattern = listOf(PROGRESS, PROGRESS, STOP)
        private var i = 0

        override fun generate(): Int {
            return pattern[i++]
        }
    }

}

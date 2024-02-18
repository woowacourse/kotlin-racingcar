package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.RacingGame

class RacingGameTest {
    @Test
    fun `올바른 자동차 전진 판단 테스트`() {
        val cars = listOf(
            Car("pobi"),
            Car("woni"),
            Car("jun"),
        )
        val racingGame = RacingGame(cars = cars)
        racingGame.racingCars()

        assertThat(cars.all { car -> car.position in 0..1 }).isTrue
    }

    @Test
    fun `올바르지 않은 자동차 전진 판단 테스트`() {
        val cars = listOf(
            Car("pobi"),
            Car("woni"),
            Car("jun"),
        )
        val racingGame = RacingGame(cars = cars)
        racingGame.racingCars()

        assertThat(cars.all { car -> car.position !in 0..1 }).isFalse
    }

    @Test
    fun `올바른 최종 우승자 판단 테스트`() {
        val carOfPobi = Car("pobi")
        val carOfWoni = Car("woni")
        val carOfJun = Car("jun")
        val cars = listOf(
            carOfPobi,
            carOfWoni,
            carOfJun,
        )
        val racingGame = RacingGame(cars)
        repeat(5) {
            carOfPobi.moveCar()
            carOfJun.moveCar()
        }
        repeat(4) {
            carOfWoni.moveCar()
        }
        val expectWinners = listOf("pobi", "jun")

        val actualWinners = racingGame.judgeWinners()

        assertThat(actualWinners).isEqualTo(expectWinners)
    }

    @Test
    fun `올바르지 최종 않은 우승자 판단 테스트`() {
        val carOfPobi = Car("pobi")
        val carOfWoni = Car("woni")
        val carOfJun = Car("jun")
        val cars = listOf(
            carOfPobi,
            carOfWoni,
            carOfJun,
        )
        val racingGame = RacingGame(cars)
        repeat(5) {
            carOfPobi.moveCar()
            carOfJun.moveCar()
        }
        repeat(4) {
            carOfWoni.moveCar()
        }
        val expectWinners = listOf("woni")

        val actualWinners = racingGame.judgeWinners()

        assertThat(actualWinners).isNotEqualTo(expectWinners)
    }
}

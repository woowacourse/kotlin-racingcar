package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.RacingGame

class RacingGameTest {
    @Test
    fun `올바른 레이싱 게임 진행 테스트`() {
        val cars = listOf(
            Car("pobi"),
            Car("woni"),
            Car("jun"),
        )
        val randomNumbers = listOf(0, 4, 9)
        val racingGame = RacingGame(cars = cars)
        racingGame.racingCars(randomNumbers)
        val expectCarSteps = listOf(0, 1, 1)
        val actualCarSteps = cars.map { car ->
            car.getStep()
        }
        assertThat(expectCarSteps).isEqualTo(actualCarSteps)
    }

    @Test
    fun `올바르지 않은 레이싱 게임 진행 테스트`() {
        val cars = listOf(
            Car("pobi"),
            Car("woni"),
            Car("jun"),
        )
        val randomNumbers = listOf(0, 4, 9)
        val racingGame = RacingGame(cars = cars)
        racingGame.racingCars(randomNumbers)
        val expectCarSteps = listOf(1, 0, 0)
        val actualCarSteps = cars.map { car ->
            car.getStep()
        }
        assertThat(expectCarSteps).isNotEqualTo(actualCarSteps)
    }

    @Test
    fun `올바른 최종 우승자 판단 테스트`() {
        val cars = listOf(
            Car("pobi"),
            Car("woni"),
            Car("jun")
        )
        cars.filter { car ->
            car.getName() == "pobi" || car.getName() == "jun"
        }.forEach { car ->
            repeat(5) {
                car.moveCar()
            }
        }
        val racingGame = RacingGame(cars)
        val expectWinners = listOf("pobi", "jun")
        val actualWinners = racingGame
            .judgeWinners()
            .map { car ->
                car.getName()
            }
        assertThat(expectWinners).isEqualTo(actualWinners)
    }

    @Test
    fun `올바르지 최종 않은 우승자 판단 테스트`() {
        val cars = listOf(
            Car("pobi"),
            Car("woni"),
            Car("jun"),
        )
        cars.filter { car ->
            car.getName() == "pobi" || car.getName() == "jun"
        }.forEach { car ->
            repeat(5) {
                car.moveCar()
            }
        }
        val racingGame = RacingGame(cars)
        val expectWinners = listOf("woni")
        val actualWinners = racingGame
            .judgeWinners()
            .map { car ->
                car.getName()
            }
        assertThat(expectWinners).isNotEqualTo(actualWinners)
    }
}

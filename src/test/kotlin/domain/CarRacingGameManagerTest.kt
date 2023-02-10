package domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CarRacingGameManagerTest {

    @Test
    fun `게임 내의 모든 자동차를 움직이려 하면 모든 자동차들이 전략대로 움직인다`() {
        val cars = getCars()
        val gameManager = CarRacingGameManager(cars)

        gameManager.allCarsTryToMoveForward()

        assertThat(cars.map { it.advanceCount }).isEqualTo(listOf(1, 1, 1))
    }

    private fun getCars(): List<Car> = listOf(
        Car("pobi", OnlyAdvanceMovingStrategy()),
        Car("tom", OnlyAdvanceMovingStrategy()),
        Car("tony", OnlyAdvanceMovingStrategy())
    )

    @Test
    fun `getWinCars 메소드를 실행하면 가장 전진 횟수가 많은 자동차들을 반환한다`() {
        val cars = getMovedCars()
        val gameManager = CarRacingGameManager(cars)

        val winCars = gameManager.getWinCars()

        assertThat(winCars.map { it.name }).isEqualTo(listOf("tom", "tony"))
    }

    private fun getMovedCars(): List<Car> {
        val cars = listOf(
            Car("pobi", OnlyAdvanceMovingStrategy()),
            Car("tom", OnlyAdvanceMovingStrategy()),
            Car("tony", OnlyAdvanceMovingStrategy())
        )

        cars[0].moveAccordingToStrategy()
        repeat(3) { cars[1].moveAccordingToStrategy() }
        repeat(3) { cars[2].moveAccordingToStrategy() }

        return cars
    }

    class OnlyAdvanceMovingStrategy() : MovingStrategy {
        override fun isMovable(): Boolean = true
    }
}

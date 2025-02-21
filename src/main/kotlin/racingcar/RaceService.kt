package racingcar

import racingcar.domain.Car
import racingcar.domain.GameResult
import kotlin.random.Random

class RaceService(
    private val random: Random,
) {
    fun getWinner(cars: List<Car>): List<Car> = cars.filter { it.distance == cars.maxOf { car -> car.distance } }

    fun race(
        raceCount: Int,
        cars: List<Car>,
    ): GameResult {
        val gameResult = GameResult()
        repeat(raceCount) { singleRace(cars, gameResult) }
        return gameResult
    }

    private fun singleRace(
        cars: List<Car>,
        gameResult: GameResult,
    ) {
        cars.forEach {
            it.moveForward(random.nextInt(0, 10))
            gameResult.appendCar(it.name, it.distance)
        }
        gameResult.breakLine()
    }
}

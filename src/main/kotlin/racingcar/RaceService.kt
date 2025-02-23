package racingcar

import racingcar.domain.Car
import racingcar.domain.GameResult
import kotlin.random.Random

class RaceService(
    private val random: Random,
) {
    fun getWinner(cars: List<Car>): List<Car> = cars.filter { it.distance == cars.maxOf { car -> car.distance } }

    fun race(
        moveTable: List<List<Int>>,
        cars: List<Car>,
    ): GameResult {
        val gameResult = GameResult()
        for (singleTable in moveTable) {
            singleRace(cars, gameResult, singleTable)
        }
        return gameResult
    }

    private fun singleRace(
        cars: List<Car>,
        gameResult: GameResult,
        singleTable: List<Int>,
    ) {
        for ((car, randomNum) in cars.zip(singleTable)) {
            car.moveForward(randomNum)
            gameResult.appendCar(car.name, car.distance)
        }
        gameResult.breakLine()
    }
}

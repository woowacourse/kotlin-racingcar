package racingcar

import racingcar.domain.Car
import racingcar.domain.GameResult
import racingcar.domain.MoveTable

class RaceService {
    fun getWinner(cars: List<Car>): List<Car> = cars.filter { it.distance == cars.maxOf { car -> car.distance } }

    fun race(moveTable: MoveTable): GameResult {
        val gameResult = GameResult()
        for (singleTable in moveTable.table) {
            singleRace(moveTable.cars, gameResult, singleTable)
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

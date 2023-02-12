package domain

import data.Car
import data.CarPath
import data.PathState
import data.generator.RacingNumberGenerator

class CarRacingGame(
    private val racingNumberGenerator: RacingNumberGenerator = RacingNumberGenerator()
) {

    fun startDriving(cars: List<Car>, numberOfTry: Int): List<CarPath> =
        cars.map { recordPath(it, numberOfTry) }

    private fun recordPath(car: Car, numberOfTry: Int): CarPath {
        val path = mutableListOf<PathState>()

        repeat(numberOfTry) {
            path.add(car.move(racingNumberGenerator.generate()))
        }

        return CarPath(car.name, path)
    }

    fun decideWinner(cars: List<Car>): List<String> {
        val maxScore = cars.getMaxScore()

        return cars.filter { car -> car.position == maxScore }
            .map { car -> car.name }
    }

    private fun List<Car>.getMaxScore(): Int = this.maxOf { it.position }
}

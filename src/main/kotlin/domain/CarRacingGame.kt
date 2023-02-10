package domain

import data.Car
import data.CarPath
import data.PathState
import data.generator.RacingNumberGenerator

class CarRacingGame {

    fun startDriving(cars: List<Car>, numberOfTry: Int): List<CarPath> {
        val carsPath = mutableListOf<CarPath>()

        cars.forEach { car ->
            carsPath.add(recordPath(car, numberOfTry))
        }

        return carsPath.toList()
    }

    private fun recordPath(car: Car, numberOfTry: Int): CarPath {
        val path = mutableListOf<PathState>()

        repeat(numberOfTry) {
            val randomNumber = RacingNumberGenerator().generate()
            path.add(car.move(randomNumber))
        }

        return CarPath(car.name, path)
    }

    fun decideWinner(cars: List<Car>): List<String> {
        val maxScore = cars.getMaxScore()
        val winners = cars.filter { car ->
            car.position == maxScore
        }.map { car ->
            car.name
        }

        return winners
    }

    private fun List<Car>.getMaxScore(): Int = this.maxOf {
        it.position
    }
}

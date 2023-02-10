package domain

import data.Car
import data.CarPath

class CarRacingGame {

    fun startDriving(cars: List<Car>, numberOfTry: Int): List<CarPath> {
        val carsPath = mutableListOf<CarPath>()

        cars.forEach { car ->
            carsPath.add(car.move(numberOfTry))
        }

        return carsPath.toList()
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

    private fun List<Car>.getMaxScore(): Int = this.maxBy { car ->
        car.position
    }.position
}

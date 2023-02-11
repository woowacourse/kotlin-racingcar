package domain

import data.Car

class CarRacingGame {

    fun moveCars(cars: List<Car>) = cars.forEach { car ->
        car.move()
    }

    fun decideWinner(cars: List<Car>): List<String> {
        val farthestDistance = cars.maxBy { car -> car.position }.position

        val winners = cars.filter { car ->
            car.position == farthestDistance
        }.map { car ->
            car.name
        }

        return winners
    }
}

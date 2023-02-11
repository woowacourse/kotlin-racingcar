package domain

import data.Car

class Referee {

    fun judgeWinners(cars: List<Car>): List<String> {
        val farthestDistance = cars.calcFarthestDistance()
        val winners = cars.filter { car ->
            car.position == farthestDistance
        }.map { car ->
            car.name
        }

        return winners
    }

    private fun List<Car>.calcFarthestDistance(): Int =
        this.maxBy { car -> car.position }.position
}

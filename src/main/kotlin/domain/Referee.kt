package domain

import model.Car

class Referee {

    fun decideWinner(cars: List<Car>): List<String> {
        val maxScore = cars.getMaxScore()

        return cars.filter { car -> car.position == maxScore }
            .map { car -> car.name }
    }

    private fun List<Car>.getMaxScore(): Int = this.maxOf { it.position }
}

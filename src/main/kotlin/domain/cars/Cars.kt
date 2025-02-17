package domain.cars

import Constants
import domain.numbergenerator.NumberGenerator

class Cars(private val cars: List<Car>) {
    fun lap(numberGenerator: NumberGenerator) {
        cars.forEach { it.moveOrStop(numberGenerator.generate()) }
    }

    fun getWinners(): String {
        val maxDistance = cars.maxOf { it.distance }
        val winnerNames = cars.filter { it.distance == maxDistance }.map { it.carName }
        return winnerNames.joinToString(Constants.WINNER_NAME_DELIMITER)
    }

    override fun toString(): String {
        return buildString {
            cars.forEach {
                appendLine(it.toString())
            }
        }
    }
}

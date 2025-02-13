package domain.cars

import Constants
import domain.numbergenerator.NumberGenerator

class Cars(input: String) {
    private val cars: List<Car> = input.split(Constants.CAR_NAME_DELIMITER).map { Car(it) }

    fun lap(numberGenerator: NumberGenerator) {
        cars.forEach { it.moveOrStop(numberGenerator) }
    }

    fun getWinners(): String {
        val maxDistance = cars.maxOf { it.getDistance() }
        val winnerNames = cars.filter { it.getDistance() == maxDistance }.map { it.carName }
        return winnerNames.joinToString(Constants.WINNER_NAME_DELIMITER) { it }
    }

    override fun toString(): String {
        return buildString {
            cars.forEach {
                appendLine(it.toString())
            }
        }
    }
}

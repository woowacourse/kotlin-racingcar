package domain.cars

import Constants

class Cars(private val cars: List<Car>) {
    fun lap(number: Int) {
        cars.forEach { it.moveOrStop(number) }
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

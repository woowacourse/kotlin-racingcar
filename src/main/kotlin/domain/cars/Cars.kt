package domain.cars

import domain.numbergenerator.NumberGenerator

class Cars(private val cars: List<Car>) {
    fun moveAll(numberGenerator: NumberGenerator) {
        cars.forEach { car ->
            car.updateDistance(numberGenerator.generate())
        }
    }

    fun getWinners(): String {
        val maxDistance = cars.maxOf { it.getDistance() }
        val winnerNames = cars.filter { it.getDistance() == maxDistance }.map { it.carName }
        return winnerNames.joinToString(WINNER_NAME_DELIMITER) { it }
    }

    fun getCars(): List<Car> = cars

    companion object {
        const val CAR_NAME_DELIMITER = ","
        const val WINNER_NAME_DELIMITER = ", "
    }
}

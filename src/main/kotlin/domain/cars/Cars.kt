package domain.cars

import domain.numbergenerator.NumberGenerator

class Cars(input: String) {
    private val cars: List<Car> = input.split(CAR_NAME_DELIMITER).map { Car(it) }

    fun moveAll(numberGenerator: NumberGenerator) {
        cars.forEach { car ->
            val randomNumber = numberGenerator.generate()
            car.updateDistanceIfMovable(randomNumber)
        }
    }

    fun getWinners(): String {
        val maxDistance = cars.maxOf { it.getDistance() }
        val winnerNames = cars.filter { it.getDistance() == maxDistance }.map { it.carName }
        return winnerNames.joinToString(WINNER_NAME_DELIMITER) { it }
    }

    override fun toString(): String {
        return buildString {
            cars.forEach {
                appendLine(it.toString())
            }
        }
    }

    companion object {
        const val CAR_NAME_DELIMITER = ","
        const val WINNER_NAME_DELIMITER = ", "
    }
}

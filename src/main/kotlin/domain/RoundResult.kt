package domain

import RandomGenerator
import constant.RacingGameOutputConstant.ROUND_RESULT_FORMAT

class RoundResult(
    private val cars: List<Car>,
) {
    private val randomGenerator = RandomGenerator(MIN_BOUND, MAX_BOUND)

    fun runEachCar() {
        for (car in cars) {
            val randomValue = getRandomNumber()
            if (isMovable(randomValue)) {
                car.moveCar()
            }
        }
    }

    fun isMovable(randomValue: Int): Boolean {
        return randomValue >= FORWARD_NUMBER
    }

    private fun getRandomNumber(): Int {
        return randomGenerator.createRandomValue()
    }

    fun getRoundResult(): List<String> {
        return cars.map { ROUND_RESULT_FORMAT.format(it.name, "-".repeat(it.currentPosition)) }
    }

    companion object {
        const val MAX_BOUND: Int = 10
        const val MIN_BOUND: Int = 0
        const val FORWARD_NUMBER: Int = 4
    }
}

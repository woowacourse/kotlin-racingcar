package racingCar.model

import racingCar.constant.RacingCarRule

class Cars(
    input: String,
    maxValue: Int = DEFAULT_RANDOM_MAX_VALUE,
    private val numberGenerator: RandomNumberGenerator = RandomNumberGenerator(maxValue),
) {
    val parsedCars: List<Car> = input.split(",").map { Car(it.trim()) }

    fun playOneRound() {
        parsedCars.forEach { car ->
            if (numberGenerator.generate() >= RacingCarRule.CAR_MOVE_POINT.value) car.moveForward()
        }
    }

    fun getWinner(): List<String> {
        val maxPosition = parsedCars.maxOf { it.getPosition() }
        val winners = parsedCars.filter { it.getPosition() == maxPosition }.map { it.name }
        return winners
    }

    companion object {
        const val DEFAULT_RANDOM_MAX_VALUE: Int = 9
    }
}

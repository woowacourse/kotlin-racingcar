package racingcar.model

import racingcar.util.RandomGenerator

class Cars(
    val cars: List<Car>,
    private val randomGenerator: RandomGenerator,
) {
    fun moveCars() {
        cars.forEach { raceCar ->
            val randomNumber = randomGenerator.getRandomNumber()
            raceCar.moveForward(randomNumber)
        }
    }

    fun getWinnerNames(): List<String> {
        val maxPosition = cars.maxOf { raceCar -> raceCar.position }
        return cars.findWinnerCars(maxPosition).toCarNames()
    }

    private fun List<Car>.findWinnerCars(maxPosition: Int) = this
        .filter { raceCar ->
            raceCar.position == maxPosition
        }

    private fun List<Car>.toCarNames() = this.map { car -> car.name }
}

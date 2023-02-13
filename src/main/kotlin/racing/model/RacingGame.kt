package racing.model

import racing.util.RandomNumberGenerator

object RacingGame {

    private val randomNumberGenerator = RandomNumberGenerator()

    fun getCars(carNames: List<String>): List<Car> {
        return carNames.map { name: String -> Car(name) }
    }

    fun moveCars(cars: List<Car>) {
        cars.forEach { car: Car -> car.move(createRandomNumber()) }
    }

    private fun createRandomNumber(): Int {
        return randomNumberGenerator.generate()
    }

    fun getWinnerNames(cars: List<Car>): List<String> {
        val maxPosition: Int = getMaxPosition(cars)
        return cars.filter { car: Car -> car.position == maxPosition }.map { car: Car -> car.name }
    }

    private fun getMaxPosition(cars: List<Car>): Int {
        return cars.maxOf { car: Car -> car.position }
    }
}

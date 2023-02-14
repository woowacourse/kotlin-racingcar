package racing.model

import racing.util.NumberGenerator

object RacingGame {

    fun moveCars(cars: List<Car>, randomNumberGenerator: NumberGenerator): List<Car> {
        cars.forEach { car: Car -> car.move(randomNumberGenerator.generate()) }
        return cars
    }

    fun getWinnerNames(cars: List<Car>): List<String> {
        val maxPosition: Int = getMaxPosition(cars)
        return cars.filter { car: Car -> car.position == maxPosition }
            .map { car: Car -> car.name }
    }

    private fun getMaxPosition(cars: List<Car>): Int {
        return cars.maxOf { car: Car -> car.position }
    }
}

package racingcar.model

import racingcar.util.Constants

class Cars {
    private lateinit var cars: List<Car>

    fun generateCars(carInput: List<String>) {
        cars = carInput.map { Car(it) }
    }

    fun playRound(): List<Car> {
        cars.forEach { car ->
            val number = (Constants.CONDITION_RANDOM_MIN..Constants.CONDITION_RANDOM_MAX).random()
            car.move(number)
        }
        return cars
    }

    fun getWinner(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}

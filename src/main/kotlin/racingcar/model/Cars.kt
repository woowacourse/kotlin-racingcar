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
        val winner = mutableListOf<String>()
        cars.forEach { car ->
            if (car.position == cars.maxOf { it.position }) {
                winner.add(car.name)
            }
        }
        return winner
    }
}

package racingcar.model

import racingcar.exceptions.RacingManagerExceptions

class RacingManager {
    private val exceptions = RacingManagerExceptions()

    fun determineWinner(cars: List<Car>): List<Car> {
        val sortedCars = cars.sortedWith { car, car2 -> if (car.compareTo(car2)) -1 else 1 }
        return sortedCars.filter { it.compareTo(sortedCars[0]) }
    }

    fun processStep(car: Car, number: Int) {
        exceptions.validateProcessStep(car, number)
        if (number >= 4) {
            car.forward()
        }
    }
}
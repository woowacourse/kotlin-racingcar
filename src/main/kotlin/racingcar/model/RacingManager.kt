package racingcar.model

import racingcar.Util
import racingcar.exceptions.RacingManagerExceptions

class RacingManager {
    private val exceptions = RacingManagerExceptions()
    private val cars = mutableListOf<Car>()
    private var attemptCount = 0

    fun initCars(names: List<String>) {
        for (name in names) {
            cars.add(Car(name))
        }
        exceptions.validateCarCount(cars)
    }

    fun setAttemptCount(attemptCount: Int) {
        this.attemptCount = attemptCount
        exceptions.validateAttemptCount(this.attemptCount)
    }

    fun determineWinner(): List<Car> {
        val sortedCars = cars.sortedWith { car, car2 -> if (car.compareTo(car2)) -1 else 1 }
        return sortedCars.filter { it.compareTo(sortedCars[0]) }
    }

    fun run(output: (car: List<Car>) -> Unit) {
        for (i in 0 until attemptCount) {
            attempt(output)
        }
    }

    private fun attempt(output: (car: List<Car>) -> Unit) {
        for (i in 0 until cars.size) {
            processStep(cars[i], Util.generateRandom())
        }
        output(cars)
    }

    fun processStep(car: Car, number: Int) {
        exceptions.validateProcessStep(car, number)
        if (number >= 4) {
            car.forward()
        }
    }
}

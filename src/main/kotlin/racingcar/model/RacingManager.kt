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

    fun run(): String {
        val result = mutableListOf<String>()
        for (i in 0 until attemptCount) {
            result.add(attempt())
        }
        return result.joinToString("\n\n")
    }

    private fun attempt(): String {
        for (i in 0 until cars.size) {
            step(i, Util.generateRandom())
        }
        return cars.joinToString("\n") { it.toString() }
    }

    fun step(index: Int, number: Int) {
        exceptions.validateProcessStep(cars[index], number)
        if (number >= 4) {
            cars[index].forward()
        }
    }
}

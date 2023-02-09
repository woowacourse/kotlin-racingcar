package racingcar.model

import racingcar.exceptions.RacingManagerExceptions
import racingcar.misc.Util
import racingcar.misc.Values

class RacingManager {
    private val cars = mutableListOf<Car>()
    private var attemptCount = 0

    fun initCars(names: List<String>) {
        cars.clear()
        for (name in names) {
            cars.add(Car(name))
        }
        RacingManagerExceptions.validateCarCount(cars)
    }

    fun setAttemptCount(attemptCount: Int) {
        this.attemptCount = attemptCount
        RacingManagerExceptions.validateAttemptCount(this.attemptCount)
    }

    fun determineWinner(): List<Car> {
        val sortedCars = cars.sortedWith { car, car2 -> if (car.compareTo(car2)) -1 else 1 }
        return sortedCars.filter { it.compareTo(sortedCars[0]) }.reversed()
    }

    fun run(): String {
        val result = mutableListOf<String>()
        for (i in 0 until attemptCount) {
            result.add(attempt())
        }
        return makeRunLog(result)
    }

    fun makeRunLog(result: List<String>) = result.joinToString("\n\n")

    private fun attempt(): String {
        for (i in 0 until cars.size) {
            step(i, Util.generateRandom())
        }
        return makeAttemptLog()
    }

    fun makeAttemptLog() = cars.joinToString("\n") { it.toString() }

    fun step(index: Int, number: Int) {
        RacingManagerExceptions.validateStep(number)
        if (number >= Values.WIN_NUMBER) {
            cars[index].forward()
        }
    }
}

package racingcar.model

import racingcar.entity.AttemptCount
import racingcar.entity.Car

class RacingManager(private val carManager: CarManager, private val attemptCount: AttemptCount) {
    fun run(): List<List<Car>> {
        return (0 until attemptCount.value).map { carManager.attempt() }
    }

    fun determineWinner(): List<Car> {
        val sortedCars = carManager.sortCarByPosition()
        return sortedCars.filter { it.compareByPosition(sortedCars[0]) }.reversed()
    }
}

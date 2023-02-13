package racingcar.service

import racingcar.model.Car
import racingcar.utils.Random

class RacingService {

    fun createCar(carName: String): Car {
        return Car(carName)
    }

    fun moveRandomly(car: Car) {
        car.move(isMove(pickRandomMoveProbability()))
    }

    fun isMove(moveProbability: Int): Boolean {
        return moveProbability >= MOVEMENT_PROBABILITY
    }

    private fun pickRandomMoveProbability(): Int {
        return Random.pickInRange(START_RANDOM_MOVEMENT_PROBABILITY, END_RANDOM_MOVEMENT_PROBABILITY)
    fun createCar(carName: String) = Car(carName)

    fun moveRandomly(car: Car) {
        if (isMove()) {
            car.move()
        }
    }

    private fun isMove(): Boolean {
        val random = Random.pickInRange(START_RANDOM_MOVEMENT_PROBABILITY, END_RANDOM_MOVEMENT_PROBABILITY)
        if (random < MOVEMENT_PROBABILITY) {
            return false
        }
        return true
    }

    fun getWinners(cars: List<Car>): List<Car> {
        val winnerStandard = cars.max()
        return cars.filter { it == winnerStandard }
    }

    companion object {
        const val START_RANDOM_MOVEMENT_PROBABILITY = 0
        const val END_RANDOM_MOVEMENT_PROBABILITY = 9
        const val START_RANDOM_MOVEMENT_PROBABILITY = 1
        const val END_RANDOM_MOVEMENT_PROBABILITY = 10
        const val MOVEMENT_PROBABILITY = 4
    }
}

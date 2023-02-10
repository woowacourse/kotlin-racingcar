package racingcar.service

import racingcar.model.Car
import racingcar.utils.END_RANDOM_MOVEMENT_PROBABILITY
import racingcar.utils.MOVEMENT_PROBABILITY
import racingcar.utils.START_RANDOM_MOVEMENT_PROBABILITY

class RacingService {

    fun createCar(carName: String) = Car(carName)

    fun moveRandomly(car: Car) {
        if (isMove()) {
            car.move()
        }
    }

    private fun isMove(): Boolean = (getRandomProbabilityInRange() < MOVEMENT_PROBABILITY)

    private fun getRandomProbabilityInRange(): Int =
        (START_RANDOM_MOVEMENT_PROBABILITY..END_RANDOM_MOVEMENT_PROBABILITY + 1).random()

    fun getWinners(cars: List<Car>): List<Car> {
        val winnerStandard = cars.max()
        return cars.filter { it == winnerStandard }
    }
}

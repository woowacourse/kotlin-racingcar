package racingcar.service

import racingcar.constants.GameConstants
import racingcar.model.Car
import racingcar.model.TryCount

class ForwardService {
    private val randomGenerator = RandomGenerator()

    private fun isForward(randomNumber: Int) =
        randomNumber >= GameConstants.FORWARD_FLAG_NUMBER

    fun process(cars: List<Car>, tryCount: TryCount) {
        tryCount.forEach {
            processStep(cars)
        }
    }

    private fun processStep(cars: List<Car>) {
        cars.forEach { car ->
            tryMovingCar(car)
        }
    }

    private fun tryMovingCar(car: Car) {
        val randomNumber = randomGenerator.generate()
        if (isForward(randomNumber)) {
            car.forward()
        }
    }
}
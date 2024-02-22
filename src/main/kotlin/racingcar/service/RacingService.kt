package racingcar.service

import racingcar.model.Car
import racingcar.utils.NumberGenerator

class RacingService(private val randomNumberGenerator: NumberGenerator) {
    fun startRace(cars: List<Car>): List<Car> {
        cars.forEach { car ->
            val randomNumber = randomNumberGenerator.generate()
            car.tryForward(randomNumber)
        }
        return cars
    }
}

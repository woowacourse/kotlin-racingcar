package racingcar.service

import racingcar.model.Car

class RacingService(private val randomGenerator: RandomGenerator = RandomGenerator()) {
    fun startRace(cars: List<Car>): List<Car> {
        cars.forEach { car ->
            val randomNumber = randomGenerator.generate()
            car.tryForward(randomNumber)
        }
        return cars
    }
}

package racingcar.service

import racingcar.model.Car

class RacingService {
    private val forwardService = ForwardService()
    private val randomGenerator = RandomGenerator()

    fun startRace(cars: List<Car>): List<Car> {
        cars.forEach { car ->
            val randomNumber = randomGenerator.generate()
            forwardService.tryForwardCar(car, randomNumber)
        }
        return cars
    }
}

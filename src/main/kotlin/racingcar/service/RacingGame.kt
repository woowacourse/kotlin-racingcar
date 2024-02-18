package racingcar.service

import racingcar.model.Car

class RacingGame(private val cars: List<Car>) {
    fun updateCarsPosition() {
        cars.forEach { car ->
            val randomNumber = RandomGenerator.generate()
            ForwardService.tryForwardCar(car, randomNumber)
        }
    }
}

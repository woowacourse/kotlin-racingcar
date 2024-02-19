package racingcar.service

import racingcar.model.Car

class RacingGame(
    private val cars: List<Car>,
    private val forwardNumberGenerator: ForwardNumberGenerator,
) {
    fun updateCarsPosition() =
        cars.forEach { car ->
            ForwardService.tryForwardCar(car, forwardNumberGenerator)
        }
}

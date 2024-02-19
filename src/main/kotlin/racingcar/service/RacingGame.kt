package racingcar.service

import racingcar.model.Car

class RacingGame(
    private val cars: List<Car>,
    private val forwardNumberGenerator: ForwardNumberGenerator,
) {
    fun updateCarsPosition() =
        cars.forEach { car ->
            tryForwardCar(car)
        }

    private fun tryForwardCar(car: Car) {
        val forwardNumber = forwardNumberGenerator.generate()
        if (isForward(forwardNumber)) {
            car.forward()
        }
    }

    private fun isForward(forwardNumber: Int) = forwardNumber >= FORWARD_FLAG_NUMBER

    fun getWinners(): List<Car> {
        val maxForwardCountCar = cars.maxOf { it.position }
        return cars.filter { car ->
            car.position == maxForwardCountCar
        }
    }

    companion object {
        private const val FORWARD_FLAG_NUMBER = 4
    }
}

package racingcar.service

import racingcar.model.Car

object ForwardService {
    private const val FORWARD_FLAG_NUMBER = 4

    private fun isForward(randomNumber: Int) = randomNumber >= FORWARD_FLAG_NUMBER

    fun tryForwardCar(
        car: Car,
        forwardNumberGenerator: ForwardNumberGenerator,
    ) {
        val forwardNumber = forwardNumberGenerator.generate()
        if (isForward(forwardNumber)) {
            car.forward()
        }
    }
}

package racingcar.service

import racingcar.constants.GameConstants
import racingcar.model.Car

object ForwardService {
    private fun isForward(randomNumber: Int) = randomNumber >= GameConstants.FORWARD_FLAG_NUMBER

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

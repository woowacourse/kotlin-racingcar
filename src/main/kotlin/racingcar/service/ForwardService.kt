package racingcar.service

import racingcar.constants.GameConstants
import racingcar.model.Car

class ForwardService {
    private fun isForward(randomNumber: Int) =
        randomNumber >= GameConstants.FORWARD_FLAG_NUMBER

    fun tryForwardCar(car: Car, randomNumber: Int) {
        if (isForward(randomNumber)) {
            car.forward()
        }
    }
}

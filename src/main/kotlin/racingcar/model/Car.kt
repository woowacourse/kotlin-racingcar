package racingcar.model

import racingcar.constants.GameConstants

class Car(val name: String) {
    var position: Int = 0
        private set

    fun tryForward(randomNumber: Int) {
        if (randomNumber >= GameConstants.FORWARD_FLAG_NUMBER) {
            forward()
        }
    }

    fun forward() {
        position++
    }
}

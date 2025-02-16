package racingcar.domain

import racingcar.utils.Constants.MOVE_MIN_RANGE

class Car(private val carName: String) {
    private var position: Int = 0

    fun getName(): String = carName

    fun getPosition(): Int = position

    fun moveOrStop(randomNumber: Int) {
        if (randomNumber >= MOVE_MIN_RANGE) {
            position++
        }
    }
}

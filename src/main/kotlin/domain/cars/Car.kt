package domain.cars

import Constants
import Constants.MOVING_STANDARD

class Car(val carName: String) {
    var distance: Int = 0
        private set

    fun moveOrStop(number: Int) {
        if (isMovable(number)) ++distance
    }

    private fun isMovable(number: Int) = number >= MOVING_STANDARD

    override fun toString(): String {
        return "$carName : ${Constants.CAR_POSITION_MARK.repeat(distance)}"
    }
}

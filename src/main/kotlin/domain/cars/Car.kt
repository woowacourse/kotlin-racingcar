package domain.cars

import Constants
import Constants.MOVING_STANDARD
import domain.numbergenerator.NumberGenerator

class Car(val carName: String) {
    private var distance: Int = 0

    fun getDistance(): Int {
        return distance
    }

    fun moveOrStop(numberGenerator: NumberGenerator) {
        val randomNumber = numberGenerator.generate()
        if (isMovable(randomNumber)) ++distance
    }

    private fun isMovable(number: Int) = number >= MOVING_STANDARD

    override fun toString(): String {
        return "$carName : ${Constants.CAR_POSITION_MARK.repeat(distance)}"
    }
}

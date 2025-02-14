package model

import util.Constants

class Car(val name: String, position: Int = INITIAL_POSITION) {
    var position: Int = position
        private set

    fun move(number: Int) {
        if (number >= Constants.CONDITION_MOVE_THRESHOLD) position++
    }

    companion object {
        const val INITIAL_POSITION = 0
    }
}

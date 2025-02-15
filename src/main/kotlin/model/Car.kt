package model

import util.Constants

data class Car(val name: String) {
    var position = INITIAL_POSITION
        private set

    fun move(number: Int) {
        if (number >= Constants.CONDITION_MOVE_THRESHOLD) position++
    }

    companion object {
        const val INITIAL_POSITION = 0
    }
}

package racingcar.model

import kotlin.random.Random

class Car(val name: String, var position: Int = INITIAL_POSITION) {

    fun move(number: Int): Int {
        if (number >= MIN_POSITION_CONDITION) position++
        return position
    }

    companion object {
        private const val MIN_POSITION_CONDITION = 4
        private const val INITIAL_POSITION = 0
    }
}

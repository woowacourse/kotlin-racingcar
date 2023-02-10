package data

import InputError

class Car(val name: String) {
    var position = INITIAL_POSITION
        private set

    init {
        require(name.length <= NAME_LENGTH_LIMIT) {
            InputError.CAR_NAME_ERROR
        }
    }

    fun move(number: Int) {
        if (number >= 4) {
            position++
        }
    }

    companion object {
        private const val INITIAL_POSITION = 0
        private const val NAME_LENGTH_LIMIT = 5
    }
}

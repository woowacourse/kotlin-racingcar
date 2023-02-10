package domain

import exception.Validator

class Car(private val name: String, private var moveCount: Int) {

    init {
        require(name.length <= MAX_NAME_LENGTH) { Validator.NAME_LENGTH_ERROR }
        require(name.isNotEmpty()) { Validator.INVALID_NAME_ERROR }
    }

    private fun move() {
        moveCount++
    }

    fun tryMove(number: Int) {
        if (number >= MIN_MOVE_NUMBER) move()
    }

    fun getMoveCount() = moveCount

    fun getName() = name

    companion object {
        private const val MIN_MOVE_NUMBER = 4
        const val MAX_NAME_LENGTH = 5
    }
}

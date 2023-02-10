package domain

import exception.InputValidator

class Car(val name: String, private var moveCount: Int) {

    init {
        require(name.length <= MAX_NAME_LENGTH) { InputValidator.NAME_LENGTH_ERROR }
        require(name.isNotEmpty()) { InputValidator.INVALID_NAME_ERROR }
    }

    private fun move() {
        moveCount++
    }

    fun tryMove(number: Int) {
        if (number >= MIN_MOVE_NUMBER) move()
    }

    fun getMoveCount() = moveCount

    companion object {
        private const val MIN_MOVE_NUMBER = 4
        const val MAX_NAME_LENGTH = 5
    }
}

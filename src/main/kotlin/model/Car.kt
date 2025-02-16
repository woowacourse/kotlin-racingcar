package model

import constant.ErrorConstant
import java.util.Random

class Car(
    val name: String,
    var currentPosition: Int = DEFAULT_POSITION,
) {
    init {
        require(name.length <= MAX_NAME_LENGTH) { ErrorConstant.ERROR_WRONG_NAME_LENGTH }
    }

    fun moveCar(random: Random) {
        val randomValue = random.nextInt(MIN_BOUND, MAX_BOUND)
        currentPosition += goOrNot(randomValue)
    }

    private fun goOrNot(moveValue: Int): Int {
        if (moveValue >= FORWARD_NUMBER) return MOVE_AMOUNT
        return NOT_MOVE_AMOUNT
    }

    companion object {
        const val DEFAULT_POSITION: Int = 0
        const val FORWARD_NUMBER: Int = 4
        const val MAX_BOUND: Int = 10
        const val MIN_BOUND: Int = 0
        const val MAX_NAME_LENGTH: Int = 5
        const val MOVE_AMOUNT: Int = 1
        const val NOT_MOVE_AMOUNT: Int = 0
    }
}

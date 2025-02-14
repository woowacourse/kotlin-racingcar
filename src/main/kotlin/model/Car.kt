package model

import constant.ErrorConstant
import java.util.Random

class Car(
    val name: String,
    var currentPosition: Int = DEFAULT_POSITION,
) {
    init {
        require(name.length <= 5) { ErrorConstant.ERROR_WRONG_NAME_LENGTH }
    }

    fun moveCar(random: Random) {
        val randomValue = random.nextInt(MIN_BOUND, MAX_BOUND)
        currentPosition += goOrNot(randomValue)
    }

    private fun goOrNot(moveValue: Int): Int {
        if (moveValue >= FORWARD_NUMBER) return 1
        return 0
    }

    companion object {
        const val DEFAULT_POSITION: Int = 0
        const val FORWARD_NUMBER: Int = 4
        const val MAX_BOUND: Int = 9
        const val MIN_BOUND: Int = 0
    }
}

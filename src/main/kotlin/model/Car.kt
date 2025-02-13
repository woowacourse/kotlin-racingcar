package model

import constant.ErrorConstant
import java.util.Random

class Car(
    val name: String,
    var currentPosition: Int = 0,
) {
    init {
        require(name.length <= 5) { ErrorConstant.ERROR_WRONG_NAME_LENGTH }
    }

    fun moveCar(random: Random) {
        val random = random.nextInt(10)
        currentPosition += goOrNot(random)
    }

    private fun goOrNot(randomValue: Int): Int {
        if (randomValue >= 4) return 1
        return 0
    }
}

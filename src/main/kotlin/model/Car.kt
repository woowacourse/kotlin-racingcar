package model

import constant.ErrorConstant
import java.util.Random

interface IntGenerator {
    fun randomGenerator(): Int
}

class Random : IntGenerator {
    override fun randomGenerator() = Random().nextInt(10)
}

class Car(
    val name: String,
    currentPosition: Int = 0,
    var randomMaker: IntGenerator = model.Random(),
) {
    init {
        when {
            name.length >= 5 -> throw IllegalArgumentException(ErrorConstant.ERROR_WRONG_NAME_LENGTH)
            name.isBlank() -> throw IllegalArgumentException(ErrorConstant.ERROR_NO_NAME)
        }
    }

    var currentPosition: Int = currentPosition
        private set

    fun moveCar() {
        currentPosition += goOrNot(randomMaker.randomGenerator())
    }

    private fun goOrNot(randomValue: Int): Int {
        if (randomValue >= 4) return 1
        return 0
    }
}

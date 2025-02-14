package model

import java.util.Random

class Car(
    val name: String,
    currentPosition: Int = 0,
) {
    var currentPosition: Int = currentPosition
        private set

    fun moveCar(random: Random) {
        val random = random.nextInt(10)
        currentPosition += goOrNot(random)
    }

    private fun goOrNot(randomValue: Int): Int {
        if (randomValue >= 4) return 1
        return 0
    }
}

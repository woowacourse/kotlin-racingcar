package domain

import kotlin.random.Random
import kotlin.random.nextInt

class Car(
    val name: String,
    var position: Int = INIT_POSITION,
) {
    fun move() {
        if (Random.nextInt(MIN_RANGE..MAX_RANGE) >= STANDARD_NUMBER) {
            ++position
        }
    }

    companion object {
        const val INIT_POSITION = 0
        const val MIN_RANGE = 0
        const val MAX_RANGE = 9
        const val STANDARD_NUMBER = 4
    }
}

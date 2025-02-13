package utils

import kotlin.random.Random
import kotlin.random.nextInt

object RandomGenerator {
    fun generateRandomNumber(): Int {
        return Random.nextInt(MIN_RANGE..MAX_RANGE)
    }

    private const val MIN_RANGE = 0
    private const val MAX_RANGE = 9
}

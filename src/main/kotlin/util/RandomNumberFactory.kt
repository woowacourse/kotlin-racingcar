package util

import kotlin.random.Random

class RandomNumberFactory {
    companion object {
        private const val fromNumber: Int = 0
        private const val untilNumber: Int = 9
        fun create(): Int {
            return Random.nextInt(fromNumber, untilNumber)
        }
    }

}

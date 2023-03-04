package utils

import java.util.*

class RandomUtil {
    companion object {
        private val random = Random()

        fun getRandomNumber(bound: Int): Int {
            return random.nextInt(bound)
        }
    }
}
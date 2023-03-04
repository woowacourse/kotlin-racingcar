package utils

import java.util.*

object RandomUtil {
    private val random = Random()

    fun getRandomNumber(bound: Int): Int {
        return random.nextInt(bound)
    }
}
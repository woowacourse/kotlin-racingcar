package racingcar.util

import java.util.*

object RandomUtil {
    private val RANDOM = Random()
    private const val RANDOM_NUMBER_MAX_BOUNDARY = 10

    fun generateRandomNumber(): Int {
        return RANDOM.nextInt(RANDOM_NUMBER_MAX_BOUNDARY)
    }
}

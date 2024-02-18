package racingcar.utils

import kotlin.random.Random

object RandomNumber {
    private const val MIN_RANDOM_NUMBER = 0
    private const val MAX_RANDOM_NUMBER = 9

    fun generator() = Random.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
}

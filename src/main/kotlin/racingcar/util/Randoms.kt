package racingcar.util

import kotlin.random.Random

private const val RANDOM_NUMBER_MAX_BOUNDARY = 10

fun generateRandomNumber(): Int {
    return Random.nextInt(RANDOM_NUMBER_MAX_BOUNDARY)
}

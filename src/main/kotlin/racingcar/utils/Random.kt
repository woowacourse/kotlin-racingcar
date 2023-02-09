package racingcar.utils

import kotlin.random.Random

object Random {

    private val random = Random(RANDOM_SEED)

    fun pickInRange(start: Int, end: Int) = random.nextInt(start, end + 1)
}
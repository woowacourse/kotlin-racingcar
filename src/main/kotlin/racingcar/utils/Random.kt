package racingcar.utils

import kotlin.random.Random

object Random {

    private val random = Random(10)

    fun pickInRange(start: Int, end: Int) = random.nextInt(start, end + 1)
}

package racingcar

import java.util.Random

class Randoms(private val amount: Int) {
    fun generate(startInclusive: Int, endExclusive: Int): List<Int> =
        (1..amount).map { getRandomNumber(startInclusive, endExclusive) }

    private fun getRandomNumber(startInclusive: Int, endExclusive: Int): Int {
        val random = Random()
        return random.nextInt(endExclusive - startInclusive) + startInclusive
    }
}

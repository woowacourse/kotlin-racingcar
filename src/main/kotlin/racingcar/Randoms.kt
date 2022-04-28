package racingcar

import java.util.Random
import java.util.stream.Collectors
import java.util.stream.IntStream

class Randoms(val amount: Int) {

    fun generate(startInclusive: Int, endExclusive: Int): List<Int> = IntStream.range(0, amount)
        .map { getRandomNumber(startInclusive, endExclusive) }
        .boxed()
        .collect(Collectors.toList())

    private fun getRandomNumber(startInclusive: Int, endExclusive: Int): Int {
        val random = Random()
        return random.nextInt(endExclusive - startInclusive) + startInclusive
    }
}

package racingcar.domain

import kotlin.random.Random

class RandomNumberGenerator : NumberGenerator {
    override fun generateNumber(MIN_NUMBER: Int, MAX_NUMBER: Int): Int {
        return Random.nextInt(MIN_NUMBER, MAX_NUMBER)
    }
}

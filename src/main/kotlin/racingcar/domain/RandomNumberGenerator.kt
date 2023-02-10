package racingcar.domain

import kotlin.random.Random

class RandomNumberGenerator : NumberGenerator {
    override fun generateNumber(minNumber: Int, maxNumber: Int): Int {
        return Random.nextInt(minNumber, maxNumber)
    }
}

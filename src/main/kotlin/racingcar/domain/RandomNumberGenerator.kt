package racingcar.domain

import kotlin.random.Random

class RandomNumberGenerator : NumberGenerator {
    override fun generateNumber(): Int {
        return Random.nextInt(MIN_NUMBER, MAX_NUMBER)
    }

    companion object {
        const val MIN_NUMBER = 0
        const val MAX_NUMBER = 9
    }
}

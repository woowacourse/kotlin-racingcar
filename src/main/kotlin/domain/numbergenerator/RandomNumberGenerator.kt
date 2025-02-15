package domain.numbergenerator

import kotlin.random.Random

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return Random.nextInt(RANDOM_NUMBER_LOWER_BOUND, RANDOM_NUMBER_UPPER_BOUND)
    }

    companion object {
        private const val RANDOM_NUMBER_LOWER_BOUND = 0
        private const val RANDOM_NUMBER_UPPER_BOUND = 9
    }
}

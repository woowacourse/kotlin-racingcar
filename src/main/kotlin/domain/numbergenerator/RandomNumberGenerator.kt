package domain.numbergenerator

import kotlin.random.Random

class RandomNumberGenerator : NumberGenerator {

    override fun generate(): Int {
        return Random.nextInt(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE)
    }

    companion object {
        const val RANDOM_LOWER_INCLUSIVE = 0
        const val RANDOM_UPPER_INCLUSIVE = 9
    }
}

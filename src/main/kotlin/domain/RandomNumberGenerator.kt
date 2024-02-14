package domain

import kotlin.random.Random

class RandomNumberGenerator : NumberGenerator {
    override fun generate() = Random.nextInt(UPPER_BOUND)

    companion object {
        private const val UPPER_BOUND = 10
    }
}
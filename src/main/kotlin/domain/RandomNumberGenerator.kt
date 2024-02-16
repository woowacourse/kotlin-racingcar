package domain

import kotlin.random.Random

object RandomNumberGenerator : NumberGenerator {
    private const val UPPER_BOUND = 10

    override fun generate() = Random.nextInt(UPPER_BOUND)
}

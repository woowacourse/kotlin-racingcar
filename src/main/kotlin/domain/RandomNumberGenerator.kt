package domain

import java.util.Random

private const val EXCLUSIVE_UPPER_BOUND = 10

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        val random = Random()
        return random.nextInt(EXCLUSIVE_UPPER_BOUND)
    }
}

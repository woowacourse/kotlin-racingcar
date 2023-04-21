package domain

import java.util.Random

class RandomNumberGenerator : NumberGenerator {
    companion object {
        private const val EXCLUSIVE_UPPER_BOUND = 10
    }

    override fun generate(): Int {
        val random = Random()
        return random.nextInt(EXCLUSIVE_UPPER_BOUND)
    }
}

package service

import kotlin.random.Random

class RandomNumberGenerator {

    fun generate(): Int = Random.nextInt(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER)

    companion object {
        const val MINIMUM_RANDOM_NUMBER = 1
        const val MAXIMUM_RANDOM_NUMBER = 9
    }
}

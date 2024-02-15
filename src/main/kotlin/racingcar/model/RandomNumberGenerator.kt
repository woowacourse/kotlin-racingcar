package racingcar.model

import kotlin.random.Random

class RandomNumberGenerator {
    fun getRandomNumber() = Random.nextInt(MINIMUM_RANDOM_SELECTION_NUM, MAXIMUM_RANDOM_SELECTION_NUM)

    companion object {
        private const val MINIMUM_RANDOM_SELECTION_NUM = 0
        private const val MAXIMUM_RANDOM_SELECTION_NUM = 10
    }
}
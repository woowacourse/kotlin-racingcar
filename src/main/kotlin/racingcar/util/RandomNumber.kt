package racingcar.util

import racingcar.model.Car
import kotlin.random.Random

class RandomNumber {
    fun getRandomNumber(): Int = Random.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)

    companion object {
        private const val MIN_RANDOM_NUMBER = 0
        private const val MAX_RANDOM_NUMBER = 9
    }
}
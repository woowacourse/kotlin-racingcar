package racingcar.random

interface RandomNumberGenerator {
    fun getRandomNumber(
        min: Int,
        max: Int,
    ): Int
}

package racingcar.utils

object RandomNumber {
    fun getRandomNumber(
        min: Int,
        max: Int,
    ): Int = (min..max).random()
}

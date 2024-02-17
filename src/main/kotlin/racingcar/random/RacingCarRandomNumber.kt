package racingcar.random

object RacingCarRandomNumber : RandomNumberGenerator {
    override fun getRandomNumber(
        min: Int,
        max: Int,
    ): Int = (min..max).random()
}

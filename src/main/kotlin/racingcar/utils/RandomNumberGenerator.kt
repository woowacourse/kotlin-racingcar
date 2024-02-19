package racingcar.utils

object RandomNumberGenerator : NumberGenerator {
    override fun generateNumber(
        start: Int,
        end: Int,
    ): Int = (start..end).random()
}

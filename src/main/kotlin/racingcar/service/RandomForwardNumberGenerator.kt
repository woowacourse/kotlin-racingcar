package racingcar.service

object RandomForwardNumberGenerator : ForwardNumberGenerator {
    private const val MIN_RANDOM_NUMBER = 0
    private const val MAX_RANDOM_NUMBER = 9

    override fun generate() = (MIN_RANDOM_NUMBER..MAX_RANDOM_NUMBER).random()
}

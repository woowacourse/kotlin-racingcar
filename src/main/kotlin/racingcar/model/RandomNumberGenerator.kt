package racingcar.model

class RandomNumberGenerator() : NumberGenerator {
    override fun generate(): Int = (MIN_RANDOM_NUMBER..MAX_RANDOM_NUMBER).random()

    companion object {
        const val MIN_RANDOM_NUMBER = 0
        const val MAX_RANDOM_NUMBER = 9
    }
}

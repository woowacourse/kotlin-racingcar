package racingcar.model.random

class RandomNumberGeneratorImpl(
    private val start: Int = RANDOM_NUMBER_MIN,
    private val end: Int = RANDOM_NUMBER_MAX,
) : RandomNumberGenerator {
    override fun invoke(): Int {
        return (start..end).random()
    }

    companion object {
        const val RANDOM_NUMBER_MIN = 0
        const val RANDOM_NUMBER_MAX = 9
    }
}

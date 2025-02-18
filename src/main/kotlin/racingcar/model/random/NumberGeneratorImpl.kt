package racingcar.model.random

class NumberGeneratorImpl(
    private val start: Int = RANDOM_NUMBER_MIN,
    private val end: Int = RANDOM_NUMBER_MAX,
) : NumberGenerator {
    override fun generate(): Int {
        return (start..end).random()
    }

    companion object {
        const val RANDOM_NUMBER_MIN = 0
        const val RANDOM_NUMBER_MAX = 9
    }
}

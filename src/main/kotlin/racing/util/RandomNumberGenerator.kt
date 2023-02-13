package racing.util

class RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        val range = MIN_RANGE..MAX_RANGE
        return range.random()
    }

    companion object {
        private const val MIN_RANGE = 0
        private const val MAX_RANGE = 9
    }
}

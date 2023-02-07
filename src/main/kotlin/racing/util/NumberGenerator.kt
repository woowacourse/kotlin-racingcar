package racing.util

class NumberGenerator : RandomNumberGenerator {
    override fun generate(): Int {
        val range = MIN_RANGE..MAX_RANGE
        return range.random()
    }

    companion object {
        const val MIN_RANGE = 0
        const val MAX_RANGE = 9
    }
}

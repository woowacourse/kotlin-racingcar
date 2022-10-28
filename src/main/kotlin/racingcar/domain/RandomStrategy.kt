package racingcar.domain

class RandomStrategy(
    private val range: IntRange = (MIN_VALUE..MAX_VALUE),
    private val threshold: Int = THRESHOLD
) : MovingStrategy {

    override fun isMovable(): Boolean {
        return range.random() >= threshold
    }

    companion object {
        const val MIN_VALUE = 0
        const val MAX_VALUE = 9
        const val THRESHOLD = 4
    }
}

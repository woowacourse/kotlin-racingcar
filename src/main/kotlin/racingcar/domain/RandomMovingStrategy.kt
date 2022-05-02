package racingcar.domain

class RandomMovingStrategy(
    private val range: IntRange = (RANDOM_MIN_VALUE..RANDOM_MAX_VALUE),
    private val threshold: Int = THRESHOLD
) : MovingStrategy {

    override fun isMovable(): Boolean {
        return range.random() >= threshold
    }

    companion object {
        const val THRESHOLD = 4
        const val RANDOM_MIN_VALUE = 0
        const val RANDOM_MAX_VALUE = 9
    }
}

package domain

class RandomMovingStrategy : MovingStrategy {
    override fun isMovable(): Boolean = (MIN_RANDOM_RANGE..MAX_RANDOM_RANGE).random() >= MOVABLE_RANDOM_THRESHOLD

    companion object {
        const val MIN_RANDOM_RANGE = 0
        const val MAX_RANDOM_RANGE = 9
        const val MOVABLE_RANDOM_THRESHOLD = 4
    }
}

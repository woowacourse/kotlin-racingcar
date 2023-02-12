package domain

class RandomMovingStrategy : MovingStrategy {
    override fun isMovable(): Boolean = (MIN_RANDOM_RANGE..MAX_RANDOM_RANGE).random() >= MOVABLE_RANDOM_THRESHOLD

    companion object {
        private const val MIN_RANDOM_RANGE = 0
        private const val MAX_RANDOM_RANGE = 9
        private const val MOVABLE_RANDOM_THRESHOLD = 4
    }
}

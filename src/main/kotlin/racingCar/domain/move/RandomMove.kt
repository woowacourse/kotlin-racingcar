package racingCar.domain.move

class RandomMove : MoveStrategy {

    override fun isMovable(): Boolean {
        return generateRandomNumber() >= MOVABLE_NUMBER_THRESHOLD
    }

    private fun generateRandomNumber(): Int {
        return (MIN_RANDOM_RANGE..MAX_RANDOM_RANGE).random()
    }

    companion object {
        private const val MIN_RANDOM_RANGE = 0
        private const val MAX_RANDOM_RANGE = 9
        private const val MOVABLE_NUMBER_THRESHOLD = 4
    }
}

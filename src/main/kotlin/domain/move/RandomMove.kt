package domain.move

private const val MIN = 0
private const val MAX = 9
private const val MOVABLE_NUMBER_THRESHOLD = 4

class RandomMove : MoveStrategy {

    override fun isMovable(): Boolean {
        return generateRandomNumber() >= MOVABLE_NUMBER_THRESHOLD
    }

    private fun generateRandomNumber(): Int {
        return (MIN..MAX).random()
    }
}

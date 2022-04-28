package domain.move

import java.util.Random

class RandomMove : MoveStrategy {

    private val RANDOM_NUMBER_RANGE = 10
    private val MOVABLE_NUMBER_THRESHOLD = 4

    override fun isMovable(): Boolean {
        return generateRandomNumber() >= MOVABLE_NUMBER_THRESHOLD
    }

    private fun generateRandomNumber(): Int {
        val random = Random()
        return random.nextInt(RANDOM_NUMBER_RANGE)
    }
}
package domain

import kotlin.random.Random

class RandomMoveStrategy : MoveStrategy {
    companion object {
        const val RANDOM_MIN = 0
        const val RANDOM_MAX = 9
    }

    override fun canMove() = Random.nextInt(RANDOM_MIN, RANDOM_MAX) >= MoveStrategy.THRESHOLD
}

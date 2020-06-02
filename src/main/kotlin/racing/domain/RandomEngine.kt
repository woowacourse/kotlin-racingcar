package racing.domain

import kotlin.random.Random

class RandomEngine : Engine {
    companion object {
        const val RANDOM_MIN = 0
        const val RANDOM_MAX = 9
    }

    override fun isMovable() = Random.nextInt(RANDOM_MIN, RANDOM_MAX) >= Engine.THRESHOLD
}

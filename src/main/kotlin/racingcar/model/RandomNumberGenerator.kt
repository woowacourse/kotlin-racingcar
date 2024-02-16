package racingcar.model

import kotlin.random.Random
import kotlin.random.nextInt

class RandomNumberGenerator {
    fun make() = Random.nextInt(MINIMUM_OF_MOVE_CONDITION..MAXIMUM_OF_MOVE_CONDITION)

    companion object {
        private const val MINIMUM_OF_MOVE_CONDITION = 0
        private const val MAXIMUM_OF_MOVE_CONDITION = 9
    }
}

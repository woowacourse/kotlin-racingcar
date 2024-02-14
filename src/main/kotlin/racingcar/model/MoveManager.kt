package racingcar.model

import kotlin.random.Random

class MoveManager {
    fun isMoveAble(): Boolean =
        Random.nextInt(MINIMUM_RANDOM_SELECTION_NUM, MAXIMUM_RANDOM_SELECTION_NUM) > STOP_THRESHOLD

    companion object {
        private const val MINIMUM_RANDOM_SELECTION_NUM = 0
        private const val MAXIMUM_RANDOM_SELECTION_NUM = 10
        private const val STOP_THRESHOLD = 3
    }
}
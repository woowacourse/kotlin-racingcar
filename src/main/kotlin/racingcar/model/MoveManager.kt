package racingcar.model

import kotlin.random.Random

class MoveManager {
    fun isMoveAble(): Boolean = Random.nextInt(0, 10) > 4
}
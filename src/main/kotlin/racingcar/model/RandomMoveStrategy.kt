package racingcar.model

import racingcar.util.RandomUtil

const val MOVE_PIVOT = 4

class RandomMoveStrategy : MoveStrategy {

    override fun move(): Boolean {
        return RandomUtil.generateRandomNumber() >= MOVE_PIVOT
    }
}

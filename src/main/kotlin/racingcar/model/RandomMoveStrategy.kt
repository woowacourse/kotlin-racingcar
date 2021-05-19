package racingcar.model

import racingcar.util.RandomUtil

class RandomMoveStrategy : MoveStrategy {

    companion object {
        const val MOVE_PIVOT: Int = 4
    }

    override fun move(): Boolean {
        return RandomUtil.generateRandomNumber() >= MOVE_PIVOT
    }
}

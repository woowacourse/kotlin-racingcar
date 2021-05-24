package racingcar.model

import racingcar.util.generateRandomNumber

class RandomMoveStrategy : MoveStrategy {
    override fun move(): Boolean {
        return generateRandomNumber() >= MOVE_PIVOT
    }

    companion object {
        const val MOVE_PIVOT: Int = 4
    }
}

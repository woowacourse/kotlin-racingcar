package racingCar.domain

import racingCar.domain.move.MoveStrategy

data class Position(var index: Int = 0) : Comparable<Position> {

    init {
        require(index >= 0) { "[ERROR] 0이상의 정수어야 합니다. " }
    }

    fun move(strategy: MoveStrategy) {
        if (strategy.isMovable()) {
            index++
        }
    }

    override fun compareTo(other: Position): Int {
        return this.index - other.index
    }
}

package domain

import domain.move.MoveStrategy

data class Position(var index: Int = 0) : Comparable<Position> {

    init {
        require(index >= 0) { "[ERROR] 0이상의 정수어야 합니다. " }
    }

    fun move(strategy: MoveStrategy): Position {
        if (strategy.isMovable()) {
            index++
            return this
        }
        return this
    }

    override fun compareTo(other: Position): Int {
        return other.index - this.index
    }
}
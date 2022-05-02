package racingcar.domain

data class Position(val distance: Int = 0) : Comparable<Position> {

    init {
        require(distance >= 0) { "위치는 0 이상의 정수여야 합니다." }
    }

    fun increase(strategy: MovingStrategy): Position {
        if (strategy.isMovable()) {
            return Position(distance + 1)
        }
        return Position(distance)
    }

    override fun compareTo(other: Position): Int {
        return this.distance.compareTo(other.distance)
    }
}

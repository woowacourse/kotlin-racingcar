package racingcar.domain

data class Position(
    val value: Int = 0,
) : Comparable<Position> {
    init {
        require(value >= 0) { "위치는 음수일 수 없습니다" }
    }

    fun increase(): Position {
        return Position(value + 1)
    }

    override fun compareTo(other: Position): Int = value.compareTo(other.value)
}

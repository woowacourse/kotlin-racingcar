package domain

data class Position(
    val value: Int = 0
) : Comparable<Position> {
    init {
        require(value >= 0) { "위치는 0 이상이어야 합니다." }
    }

    fun increase(): Position = Position(value + 1)

    override fun compareTo(other: Position): Int = value.compareTo(other.value)
}

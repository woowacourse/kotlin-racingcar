package racingcar.domain

private const val MIN_POSITION = 0

data class Position(val position: Int) : Comparable<Position> {
    init {
        require(position >= MIN_POSITION)
    }

    fun plus() = Position(position + 1)

    override fun compareTo(other: Position): Int = position - other.position
}
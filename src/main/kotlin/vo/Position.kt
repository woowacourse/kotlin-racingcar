package vo

data class Position(var position: Int = 0) : Comparable<Position> {
    init {
        require(position >= 0) { "시도할 횟수는 양수만 입력 가능합니다." }
    }

    fun forward() {
        position++
    }

    override fun toString(): String {
        return position.toString()
    }

    override fun compareTo(other: Position): Int {
        return other.position - this.position
    }

    fun value(): Int {
        return position
    }
}

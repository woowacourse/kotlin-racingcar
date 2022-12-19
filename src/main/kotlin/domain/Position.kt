package domain

class Position(
    val value: Int
) {
    init {
        require(value >= 0) {
            "위치는 0 이상이어야 합니다."
        }
    }

    fun increase(): Position {
        return Position(value + 1)
    }
}

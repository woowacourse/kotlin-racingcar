package domain

class Position(
    val value: Int = 0
) {
    init {
        require(value >= 0) {
            "위치는 0 이상이어야 합니다."
        }
    }

    fun increase(): Position {
        return Position(value + 1)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Position

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }
}

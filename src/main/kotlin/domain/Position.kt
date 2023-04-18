package domain

class Position(val position: Int) {

    init {
        validateNegative(position)
    }

    private fun validateNegative(position: Int) {
        if (position < 0) {
            throw IllegalArgumentException("자동차의 위치는 0보다 작을 수 없습니다.")
        }
    }

    fun increase(): Position {
        return Position(this.position + 1)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Position

        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        return position
    }
}

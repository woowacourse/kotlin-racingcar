package domain

private const val MIN_VALUE = 0

class Position(val value: Int) {

    init {
        validateNegative(value)
    }

    private fun validateNegative(position: Int) {
        require(position >= MIN_VALUE) { "자동차의 위치는 $MIN_VALUE 보다 작을 수 없습니다." }
    }

    fun increase(): Position {
        return Position(this.value + 1)
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

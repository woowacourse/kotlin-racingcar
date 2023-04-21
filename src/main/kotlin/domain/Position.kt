package domain

data class Position(val value: Int) {
    companion object {
        private const val MIN_VALUE = 0
    }

    init {
        validateNegative(value)
    }

    private fun validateNegative(position: Int) {
        require(position >= MIN_VALUE) { "자동차의 위치는 $MIN_VALUE 보다 작을 수 없습니다." }
    }

    fun increase(): Position {
        return Position(this.value + 1)
    }
}

package racingcar.domain

data class Position(val distance: Int = 0) {
    init {
        require(distance >= 0) { "위치는 0 이상의 정수여야 합니다." }
    }

    fun increase(): Position {
        return Position(distance + 1)
    }
}

package racingcar.domain

class Position(val distance: Int) {
    init {
        if (distance < 0) {
            throw IllegalArgumentException("위치는 0 이상의 정수여야 합니다.")
        }
    }

    fun increase(): Position {
        return Position(distance + 1)
    }
}

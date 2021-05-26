package racingcar.domain

val STARTING_POSITION = Position(0)

data class Position(val value: Int) {

    init {
        require(value >= 0) { "위치는 음수일 수 없습니다." }
    }

    fun moveForward(): Position {
        return Position(value + 1)
    }
}
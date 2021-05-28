package racingcar.domain

data class Position(val value: Int) {

    init {
        require(value >= 0) { "위치는 음수일 수 없습니다." }
    }

    fun moveForward(): Position {
        return Position(value + 1)
    }

    companion object {
        val STARTING_POSITION = Position(0)
    }
}
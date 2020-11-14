package racingcar.domain

const val MIN_POSITION = 0

data class Position(val position: Int) {
    init {
        require(position >= MIN_POSITION)
    }

    fun go() = Position(position + 1)
}
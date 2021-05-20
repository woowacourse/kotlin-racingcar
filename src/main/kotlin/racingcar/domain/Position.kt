package racingcar.domain

val STARTING_POSITION = Position(0)

class Position(position: Int) {

    private val value: Int

    init {
        if (position < 0) {
            throw IllegalArgumentException("위치는 음수일 수 없습니다.")
        }
        this.value = position
    }

    fun moveForward(): Position {
        return Position(value + 1)
    }

    fun value(): Int {
        return value
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
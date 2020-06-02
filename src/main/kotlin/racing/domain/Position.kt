package racing.domain

class Position(val value: Int = 0) {
    fun moveForward() = Position(value + 1)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Position
        if (value != other.value) return false
        return true
    }
}

package domain

private const val MIN_VALUE = 0
private const val INCREASE_VALUE = 1

data class Position(private val position: Int = MIN_VALUE) {
    init {
        require(position >= MIN_VALUE) { "음수는 허용되지 않습니다." }
    }

    fun move() = Position(position.plus(INCREASE_VALUE))

    fun intValue() = position
}
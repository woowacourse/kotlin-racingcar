package domain

const val DEFAULT_VALUE = 0
const val INCREASE_VALUE = 1

data class Position(private val position: Int = DEFAULT_VALUE) {
    fun move() = Position(position.plus(INCREASE_VALUE))

    fun getPosition() = position
}
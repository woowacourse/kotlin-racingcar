package domain

class Position(var value: Int = 0) {
    fun moveForward() = value++
}

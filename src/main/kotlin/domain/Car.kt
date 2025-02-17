package domain

class Car(
    val name: String,
    position: Int = INIT_POSITION,
) {
    var position: Int = position
        private set

    fun isMovable(number: Int): Boolean {
        return number < MOVE_CONDITION
    }

    fun move() {
        ++position
    }

    companion object {
        const val INIT_POSITION = 0
        const val MOVE_CONDITION = 4
    }
}

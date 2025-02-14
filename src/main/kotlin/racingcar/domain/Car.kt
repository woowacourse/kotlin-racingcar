package racingcar.domain

class Car(val carName: String) {
    val position = mutableListOf<String>()

    fun moves(randomNumber: Int) {
        when (randomNumber) {
            in MOVE_MIN_RANGE..MOVE_MAX_RANGE -> position.add(MOVE)
            else -> position.add(STOP)
        }
    }

    fun moveCount(): Int {
        return position.count { it == MOVE }
    }

    companion object {
        const val MOVE_MIN_RANGE = 4
        const val MOVE_MAX_RANGE = 9
        const val MOVE = "-"
        const val STOP = ""
    }
}

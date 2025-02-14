package racingcar.model

class Car(
    val name: String,
    position: Int = DEFAULT_POSITION,
) {
    var position = position
        private set

    fun move(number: Int) {
        if (number >= CONDITION_MOVE_THRESHOLD) position++
    }

    companion object {
        const val DEFAULT_POSITION = 0
        const val CONDITION_MOVE_THRESHOLD = 4
    }
}

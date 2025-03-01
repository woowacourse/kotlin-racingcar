package racingcar.domain

class Car(val carName: String) {
    var position: Int = DEFAULT_POSITION
        private set

    fun moves(randomNumber: Int) {
        if (randomNumber in MOVE_MIN_RANGE..MOVE_MAX_RANGE) position++
    }

    companion object {
        private const val MOVE_MIN_RANGE = 4
        private const val MOVE_MAX_RANGE = 9
        private const val DEFAULT_POSITION = 0
    }
}

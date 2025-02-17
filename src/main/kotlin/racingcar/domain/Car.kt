package racingcar.domain

class Car(private val carName: String) {
    private var position: Int = 0

    fun getName(): String = carName

    fun getPosition(): Int = position

    fun moveOrStop(randomNumber: Int) {
        if (randomNumber >= MOVE_MIN_RANGE) {
            position++
        }
    }

    companion object {
        private const val MOVE_MIN_RANGE = 4
    }
}

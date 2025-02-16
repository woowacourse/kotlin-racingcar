package racingCar.model

data class Car(
    val name: String,
) {
    var position: Int = INIT_POSITION
        private set

    fun moveForward(number: Int) {
        if (number >= MINIMUM_MOVE_POINT) position++
    }

    companion object {
        const val MINIMUM_MOVE_POINT = 4
        const val INIT_POSITION = 0
    }
}

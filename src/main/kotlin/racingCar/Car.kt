package racingCar

class Car(
    val name: String,
) {
    var position: Int = INITIAL_CAR_POSITION
        private set

    init {
        require(name.isNotBlank()) { CarErrorConstant.BLANK_NAME }
        require(name.length in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH) { CarErrorConstant.OUT_OF_RANGE_NAME }
    }

    fun moveForward(isMoved: Boolean) {
        if (isMoved) position++
    }

    companion object {
        const val MIN_CAR_NAME_LENGTH = 1
        const val MAX_CAR_NAME_LENGTH = 5
        private const val INITIAL_CAR_POSITION = 0
    }
}

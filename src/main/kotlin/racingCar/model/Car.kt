package racingCar.model

class Car(
    val name: String,
    position: Int = INITIAL_CAR_POSITION,
) {
    var position: Int = position
        private set

    init {
        require(name.isNotBlank()) { BLANK_NAME_ERROR_MESSAGE }
        require(name.length in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH) { OUT_OF_RANGE_NAME_LENGTH_ERROR_MESSAGE }
    }

    fun moveForward() {
        position++
    }

    companion object {
        private const val INITIAL_CAR_POSITION = 0
        private const val MIN_CAR_NAME_LENGTH = 1
        private const val MAX_CAR_NAME_LENGTH = 5
        private const val BLANK_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름은 공백일 수 없습니다."
        private const val OUT_OF_RANGE_NAME_LENGTH_ERROR_MESSAGE =
            "[ERROR] 자동차 이름은 ${MIN_CAR_NAME_LENGTH}자 이상 ${MAX_CAR_NAME_LENGTH}자 이하여야 합니다."
    }
}

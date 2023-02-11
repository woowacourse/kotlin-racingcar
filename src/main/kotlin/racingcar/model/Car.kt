package racingcar.model

class Car(val name: String) {
    var position: Int = 0
        private set

    init {
        require(name.length in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH) {
            CAR_NAME_LENGTH_OVER_BOUNDARY_ERROR_MESSAGE
        }
    }

    fun move(condition: Int) {
        if (condition >= MOVEMENT_PROBABILITY) {
            ++position
        }
    }

    companion object {
        private const val MIN_CAR_NAME_LENGTH = 1
        private const val MAX_CAR_NAME_LENGTH = 5
        private const val MOVEMENT_PROBABILITY = 4

        private const val CAR_NAME_LENGTH_OVER_BOUNDARY_ERROR_MESSAGE =
            "자동차 이름 길이의 범위는 $MIN_CAR_NAME_LENGTH 이상 $MAX_CAR_NAME_LENGTH 이하입니다."
    }
}

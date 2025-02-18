package racingcar.model

class Car(
    val name: String,
    position: Int = INITIAL_CAR_POSITION,
) {
    init {
        validateCarName(name)
    }

    var position: Int = position
        private set

    private fun validateCarName(carName: String) {
        require(carName.isNotBlank()) { "[ERROR] 자동차 이름은 공백일 수 없습니다. (입력한 이름: $carName)" }
        require(carName.length in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH) {
            "[ERROR] 자동차 이름은 ${MIN_CAR_NAME_LENGTH}자 이상 ${MAX_CAR_NAME_LENGTH}자 이하여야 합니다. (입력한 이름: $carName)"
        }
    }

    fun moveForward(number: Int) {
        if (isCarAbleToMove(number)) position++
    }

    private fun isCarAbleToMove(condition: Int): Boolean = condition >= MIN_RANDOM_AVAILABILITY_CONDITION

    companion object {
        private const val INITIAL_CAR_POSITION = 0
        private const val MIN_CAR_NAME_LENGTH = 1
        private const val MAX_CAR_NAME_LENGTH = 5
        private const val MIN_RANDOM_AVAILABILITY_CONDITION = 4
    }
}

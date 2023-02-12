package model

class Car(
    val name: String,
    position: Int = CAR_START_POSITION
) {
    var position: Int = position
        private set

    init {
        require(name.length <= CAR_NAME_MAX) {
            CAR_NAME_NUMBER_ERROR_MSG
        }
        require(name.isNotBlank()) {
            CAR_NAME_BLANK_ERROR_MSG
        }
    }

    fun move(condition: Int): PathState {
        if (condition >= MOVE_LEAST_NUMBER) {
            position++
            return PathState.MOVE
        }

        return PathState.STOP
    }

    companion object {
        const val CAR_START_POSITION = 0
        const val CAR_NAME_MAX = 5
        const val CAR_NAME_NUMBER_ERROR_MSG = "[ERROR] 자동차 이름은 5자를 초과할 수 없습니다."
        const val CAR_NAME_BLANK_ERROR_MSG = "[ERROR] 자동차 이름은 공백이 될 수 없습니다."
        const val MOVE_LEAST_NUMBER = 4
    }
}

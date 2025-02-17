package racingcar.model

import racingcar.enums.MoveState

class Car(val name: String) {
    var position: Int = 0
        private set

    init {
        validateNameLength(name)
        validateNameFormat(name)
    }

    fun move(moveState: MoveState) {
        when (moveState) {
            MoveState.MOVABLE -> position++
            MoveState.UNMOVABLE -> return
        }
    }

    private fun validateNameLength(name: String) {
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) { INVALID_NAME_LENGTH_ERROR }
    }

    private fun validateNameFormat(name: String) {
        require(name.matches(regex)) { INVALID_NAME_FORMAT_ERROR }
    }

    companion object {
        private const val ERROR = "[ERROR]"
        const val INVALID_NAME_LENGTH_ERROR = "$ERROR 자동차 이름은 1~5자이어야 합니다."
        const val INVALID_NAME_FORMAT_ERROR = "$ERROR 자동차 이름은 영문 또는 숫자로 이루어져야 합니다."

        const val MIN_NAME_LENGTH = 1
        const val MAX_NAME_LENGTH = 5

        private val regex = Regex("^[a-zA-Z0-9]*\$")
    }
}

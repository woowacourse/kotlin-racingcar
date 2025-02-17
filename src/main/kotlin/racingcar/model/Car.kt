package racingcar.model

import racingcar.enums.MoveState
import racingcar.util.ErrorConstants.ERROR

class Car(val name: String) {
    var position: Int = 0
        private set

    init {
        validateNameLength(name)
        validateNameFormat(name)
    }

    fun moveCarWhenMovable(moveState: MoveState) {
        when (moveState) {
            MoveState.MOVABLE -> position++
            MoveState.UNMOVABLE -> return
        }
    }

    private fun validateNameLength(name: String) {
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) { INVALID_NAME_LENGTH_ERROR }
    }

    private fun validateNameFormat(name: String) {
        val regex = Regex("^[a-zA-Z0-9]*\$")
        require(name.matches(regex)) { INVALID_NAME_FORMAT_ERROR }
    }

    companion object {
        const val INVALID_NAME_LENGTH_ERROR = "$ERROR 자동차 이름은 1~5자이어야 합니다."
        const val INVALID_NAME_FORMAT_ERROR = "$ERROR 자동차 이름은 영문 또는 숫자로 이루어져야 합니다."

        const val MIN_NAME_LENGTH = 1
        const val MAX_NAME_LENGTH = 5
    }
}

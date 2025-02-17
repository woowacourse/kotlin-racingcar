package racingcar.model

import racingcar.constants.ErrorMessages
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
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) { ErrorMessages.INVALID_NAME_LENGTH_ERROR }
    }

    private fun validateNameFormat(name: String) {
        require(name.matches(regex)) { ErrorMessages.INVALID_NAME_FORMAT_ERROR }
    }

    companion object {
        const val MIN_NAME_LENGTH = 1
        const val MAX_NAME_LENGTH = 5

        private val regex = Regex("^[a-zA-Z0-9]*\$")
    }
}

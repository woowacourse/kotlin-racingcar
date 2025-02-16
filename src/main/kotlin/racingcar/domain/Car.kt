package racingcar.domain

import racingcar.InputValidator

class Car(
    val name: String,
    private val inputValidator: InputValidator,
) {
    var distance: Int = 0
        private set

    init {
        carNameLengthCheck(name)
    }

    fun moveByValue(value: Int) {
        inputValidator.possibleMoveValueCheck(value)
        if (value >= 4) distance++
    }

    companion object {
        private fun carNameLengthCheck(name: String) {
            require(name.length in 1..5) { Messages.ERROR_NAME_LENGTH.message }
        }
    }
}

package racingcar.validator

import racingcar.constants.ErrorMessages

object InputValidator {
    fun validateNotEmpty(input: String) {
        require(input.isNotBlank()) { ErrorMessages.EMPTY_INPUT_ERROR }
    }
}

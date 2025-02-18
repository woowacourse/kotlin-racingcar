package racingcar.validator

import racingcar.constants.ErrorMessages

object RoundsValidator {
    private const val MIN_ROUNDS = 1
    private const val MAX_ROUNDS = 10

    fun validate(input: String) {
        validateNumeric(input)
        validateRange(input)
    }

    private fun validateNumeric(input: String) {
        require(input.toIntOrNull() != null) { ErrorMessages.NOT_NUMERIC_ERROR }
    }

    private fun validateRange(input: String) {
        val rounds = input.toInt()
        require(rounds in MIN_ROUNDS..MAX_ROUNDS) { ErrorMessages.INVALID_RANGE_ERROR }
    }
}

import Constants.CAR_NAME_DELIMITER
import Constants.CAR_NAME_LOWER_BOUND
import Constants.CAR_NAME_UPPER_BOUND
import Constants.ERROR_DUPLICATED_CAR_NAME_MESSAGE_WITH_INPUT
import Constants.ERROR_EMPTY_CAR_NAME_MESSAGE_WITH_INPUT
import Constants.ERROR_EMPTY_TRY_COUNT_MESSAGE_WITH_INPUT
import Constants.ERROR_IS_NOT_NUMBER_MESSAGE_WITH_INPUT
import Constants.ERROR_OUT_OF_BOUND_CAR_NAME_MESSAGE_WITH_INPUT
import Constants.ERROR_OUT_OF_BOUND_TRY_COUNT_MESSAGE_WITH_INPUT
import Constants.TRY_COUNT_LOWER_BOUND
import Constants.TRY_COUNT_UPPER_BOUND

object InputValidator {
    fun validateCarName(input: String) {
        require(input.isNotBlank()) { ERROR_EMPTY_CAR_NAME_MESSAGE_WITH_INPUT.format(input) }
        val carNames = input.split(CAR_NAME_DELIMITER)
        carNames.forEach {
            validateCarNameLength(it)
        }
        require(validateDuplicatedCarName(carNames)) { ERROR_DUPLICATED_CAR_NAME_MESSAGE_WITH_INPUT.format(input) }
    }

    private fun validateCarNameLength(input: String) {
        require(input.length in CAR_NAME_LOWER_BOUND..CAR_NAME_UPPER_BOUND) {
            ERROR_OUT_OF_BOUND_CAR_NAME_MESSAGE_WITH_INPUT.format(input)
        }
    }

    private fun validateDuplicatedCarName(input: List<String>): Boolean {
        return input.distinct().size == input.size
    }

    fun validateTryCount(input: String) {
        require(input.isNotBlank()) { ERROR_EMPTY_TRY_COUNT_MESSAGE_WITH_INPUT.format(input) }
        require(input.toIntOrNull() != null) { ERROR_IS_NOT_NUMBER_MESSAGE_WITH_INPUT.format(input) }
        require(input.toIntOrNull() in TRY_COUNT_LOWER_BOUND..TRY_COUNT_UPPER_BOUND) {
            ERROR_OUT_OF_BOUND_TRY_COUNT_MESSAGE_WITH_INPUT.format(input)
        }
    }
}

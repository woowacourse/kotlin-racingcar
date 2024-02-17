package racingcar.view.input

import racingcar.constants.ErrorConstants
import racingcar.constants.GameConstants

object InputValidator {
    fun validateCarNames(inputCarNames: String?) {
        require(!inputCarNames.isNullOrEmpty())
        val carNames = splitCarNames(inputCarNames)
        carNames.forEach { carName ->
            require(validateCarNameLength(carName) && validateCarNameRegex(carName)) {
                ErrorConstants.INVALID_INPUT_ERROR_MESSAGE
            }
        }
        require(validateCarNamesDuplication(carNames)) {
            ErrorConstants.INVALID_INPUT_ERROR_MESSAGE
        }
    }

    private fun splitCarNames(inputCarNames: String) =
        inputCarNames.split(GameConstants.SPLIT_DELIMITER)

    private fun validateCarNameLength(carName: String) =
        carName.length in GameConstants.CAR_NAME_RANGE

    private fun validateCarNameRegex(carName: String) =
        Regex(GameConstants.CAR_NAME_REGEX).matches(carName)

    private fun validateCarNamesDuplication(carNames: List<String>) =
        carNames.size == carNames.distinct().size

    fun validateTryCount(inputTryCount: String?) {
        require(!inputTryCount.isNullOrEmpty())
        require(validateTryCountType(inputTryCount) && validateTryCountRange(inputTryCount)) {
            ErrorConstants.INVALID_INPUT_ERROR_MESSAGE
        }
    }

    private fun validateTryCountType(inputTryCount: String) =
        inputTryCount.toIntOrNull() != null

    private fun validateTryCountRange(inputTryCount: String) =
        inputTryCount.toInt() in GameConstants.TRY_COUNT_RANGE
}

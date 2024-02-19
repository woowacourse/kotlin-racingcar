package racingcar.util

object InputValidator {
    fun validateCarNames(carNames: List<String>) {
        validateNumberOfCar(carNames)
        validateCarNamesDuplicate(carNames)
        carNames.forEach { carName ->
            validateCarNameFormat(carName)
            validateCarNameLength(carName)
        }
    }

    fun validateNumberOfRound(numberOfRound: String) {
        validateNumberOfRoundFormat(numberOfRound)
        validateNumberOfRoundRange(numberOfRound)

    }

    private fun validateNumberOfCar(carNames: List<String>) {
        require(carNames.isNotEmpty()) {
            InputException.INVALID_NUMBER_OF_CAR.getMessage()
        }
    }

    private fun validateCarNamesDuplicate(carNames: List<String>) {
        require(carNames.toSet().size == carNames.size) {
            InputException.INVALID_CAR_NAMES_DUPLICATE.getMessage()
        }
    }

    private fun validateCarNameFormat(carName: String) {
        require(!carName.contains(" ")) {
            InputException.INVALID_CAR_NAME_FORMAT.getMessage()
        }
    }

    private fun validateCarNameLength(carName: String) {
        require(carName.length in Constant.MIN_CAR_NAME_LENGTH..Constant.MAX_CAR_NAME_LENGTH) {
            InputException.INVALID_CAR_NAME_LENGTH.getMessage()
        }
    }

    private fun validateNumberOfRoundFormat(numberOfRound: String) {
        requireNotNull(numberOfRound.toIntOrNull()) {
            InputException.INVALID_NUMBER_OF_ROUND_FORMAT.getMessage()
        }
    }

    private fun validateNumberOfRoundRange(numberOfRound: String) {
        require(numberOfRound.toInt() >= Constant.MIN_NUMBER_OF_ROUND) {
            InputException.INVALID_NUMBER_OF_ROUND_RANGE.getMessage()
        }
    }
}

package racingcar

import racingcar.util.Constant
import racingcar.util.Exception

class Validator {
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
        require(carNames.isEmpty()) {
            Exception.INVALID_NUMBER_OF_CAR.getMessage()
        }
    }

    private fun validateCarNamesDuplicate(carNames: List<String>) {
        require(carNames.toSet().size == carNames.size) {
            Exception.INVALID_CAR_NAMES_DUPLICATE.getMessage()
        }
    }

    private fun validateCarNameFormat(carName: String) {
        require(!carName.contains(" ")) {
            Exception.INVALID_CAR_NAME_FORMAT.getMessage()
        }
    }

    private fun validateCarNameLength(carName: String) {
        require(carName.length in Constant.MIN_CAR_NAME_LENGTH..Constant.MAX_CAR_NAME_LENGTH) {
            Exception.INVALID_CAR_NAME_LENGTH.getMessage()
        }
    }

    private fun validateNumberOfRoundFormat(numberOfRound: String) {
        requireNotNull(numberOfRound.toIntOrNull()) {
            Exception.INVALID_NUMBER_OF_ROUND_FORMAT.getMessage()
        }
    }

    private fun validateNumberOfRoundRange(numberOfRound: String) {
        require(numberOfRound.toInt() >= Constant.MIN_NUMBER_OF_ROUND) {
            Exception.INVALID_NUMBER_OF_ROUND_RANGE.getMessage()
        }
    }
}

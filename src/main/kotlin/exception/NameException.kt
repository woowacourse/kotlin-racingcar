package exception

import message.ExceptionMessage

class NameException(carNames: String) {
    init {
        NullException(carNames)
        checkNames(carNames)
    }

    private fun checkNames(carNames: String) {
        splitCarNames(carNames).forEach { name ->
            NullException(name)
            checkNameRange(name)
            checkCarNameEnglishNumber(name)
        }
    }

    private fun checkNameRange(carName: String) {
        if (carName.isEmpty() || carName.length > 5) {
            throw IllegalArgumentException(ExceptionMessage.NAME_RANGE_ERROR_MASSAGE)
        }
    }

    private fun splitCarNames(carNames: String): List<String> {
        return carNames.split(",")
    }

    private fun checkCarNameEnglishNumber(carName: String) {
        if (!Regex("^[a-zA-Z0-9]*\$").matches(carName))
            throw IllegalArgumentException(ExceptionMessage.NAME_IS_ONLY_ENGLISH_AND_NUMBER)
    }
}

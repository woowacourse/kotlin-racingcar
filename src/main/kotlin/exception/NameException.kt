package exception

import message.ExceptionMessage

class NameException(carNames: String?) {
    init {
        checkEmpty(carNames)
        checkNames(carNames)
    }

    private fun checkEmpty(carNames: String?) {
        if (carNames.isNullOrEmpty())
            throw IllegalArgumentException(ExceptionMessage.NAME_IS_EMPTY_ERROR_MESSAGE)
    }

    private fun checkNames(carNames: String?) {
        splitCarNames(carNames!!).forEach { name ->
            checkNameRange(name)
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
}

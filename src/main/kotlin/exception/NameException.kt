package exception

import message.ExceptionMessage

class NameException(carNames: List<String>) {
    init {
        checkNameRange(carNames)
    }

    private fun checkNameRange(carNames: List<String>) {
        carNames.forEach { name ->
            if (name.isEmpty() || name.length > 5) {
                throw IllegalArgumentException(ExceptionMessage.NAME_RANGE_ERROR_MASSAGE)
            }
        }
    }
}

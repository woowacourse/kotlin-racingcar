package exception

import message.ExceptionMessage

class NameException(private val nullException: NullException = NullException()) {

    fun checkNames(carNames: String) {
        splitCarNames(carNames).forEach { name ->
            checkNameRange(nullException.checkNull(name))
            checkCarNameEnglishNumber(name)
        }
    }

    fun checkNameRange(carName: String) {
        if (carName.isEmpty() || carName.length > 5) {
            throw IllegalArgumentException(ExceptionMessage.NAME_RANGE_ERROR_MASSAGE)
        }
    }

    private fun splitCarNames(carNames: String): List<String> {
        return carNames.split(",")
    }

    fun checkCarNameEnglishNumber(carName: String) {
        if (!Regex("^[a-zA-Z0-9]*\$").matches(carName))
            throw IllegalArgumentException(ExceptionMessage.NAME_IS_ONLY_ENGLISH_AND_NUMBER)
    }
}

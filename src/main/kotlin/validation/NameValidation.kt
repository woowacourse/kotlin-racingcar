package validation

import message.ExceptionMessage

class NameValidation(private val nullValidation: NullValidation = NullValidation()) {

    fun checkNames(carNames: String) {
        splitCarNames(carNames).forEach { name ->
            checkNameRange(nullValidation.checkNull(name))
            checkCarNameEnglishNumber(name)
        }
    }

    fun checkNameRange(carName: String) {
        if (carName.isEmpty() || carName.length > MAXIMUM_CAR_NAME_LENGTH) {
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

    companion object {
        const val MAXIMUM_CAR_NAME_LENGTH = 5
    }
}

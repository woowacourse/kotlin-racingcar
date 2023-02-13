package racingcar.domain.validator

object InputValidator {
    private const val MAX_NAME_LENGTH = 5

    fun isNameLengthInRange(value: String): Boolean {
        val length = value.length
        return !(length <= 0 || length > MAX_NAME_LENGTH)
    }
}


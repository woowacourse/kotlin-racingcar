package racingcar.validator

object RoundsValidator {
    fun validate(input: String) {
        validateNumeric(input)
        validateRange(input)
    }

    private fun validateNumeric(input: String) {
        require(input.toIntOrNull() != null) { NOT_NUMERIC_ERROR }
    }

    private fun validateRange(input: String) {
        val rounds = input.toInt()
        require(rounds in MIN_ROUNDS..MAX_ROUNDS) { INVALID_RANGE_ERROR }
    }

    private const val ERROR = "[ERROR]"
    const val NOT_NUMERIC_ERROR = "$ERROR 숫자를 입력해야 합니다."
    const val INVALID_RANGE_ERROR = "$ERROR 1에서 10 사이의 수를 입력해야 합니다."

    private const val MIN_ROUNDS = 1
    private const val MAX_ROUNDS = 10
}

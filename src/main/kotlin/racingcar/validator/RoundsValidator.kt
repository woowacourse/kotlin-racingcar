package racingcar.validator

class RoundsValidator {
    fun validate(input: String): Int {
        isNotEmpty(input)
        isNumeric(input)
        return 0
    }

    private fun isNotEmpty(rounds: String) {
        require(rounds.isNotBlank()) { EMPTY_INPUT_ERROR }
    }

    private fun isNumeric(rounds: String) {
        require(rounds.toIntOrNull() != null) { NOT_NUMERIC_ERROR }
    }

    companion object {
        private const val ERROR = "[ERROR]"
        const val EMPTY_INPUT_ERROR = "$ERROR 빈 값을 입력하셨습니다."
        const val NOT_NUMERIC_ERROR = "$ERROR 숫자를 입력해야 합니다."
    }
}

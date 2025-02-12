package racingcar.validator

class RoundsValidator {
    fun validate(input: String): Int {
        isNotEmpty(input)
        isNumeric(input)
        val rounds = input.toInt()
        isValidRange(rounds)
        return rounds
    }

    private fun isNotEmpty(rounds: String) {
        require(rounds.isNotBlank()) { EMPTY_INPUT_ERROR }
    }

    private fun isNumeric(rounds: String) {
        require(rounds.toIntOrNull() != null) { NOT_NUMERIC_ERROR }
    }

    private fun isValidRange(rounds: Int) {
        require(rounds in MIN_ROUNDS..MAX_ROUNDS) { INVALID_RANGE_ERROR }
    }

    companion object {
        private const val ERROR = "[ERROR]"
        const val EMPTY_INPUT_ERROR = "$ERROR 빈 값을 입력하셨습니다."
        const val NOT_NUMERIC_ERROR = "$ERROR 숫자를 입력해야 합니다."
        const val INVALID_RANGE_ERROR = "$ERROR 1에서 10 사이의 수를 입력해야 합니다."

        const val MIN_ROUNDS = 1
        const val MAX_ROUNDS = 10
    }
}

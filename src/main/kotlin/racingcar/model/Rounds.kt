package racingcar.model

import racingcar.util.ErrorConstants.ERROR

@JvmInline
value class Rounds(
    val value: Int,
) {
    init {
        validate(value)
    }

    fun validate(value: Int) {
        validateRange(value)
    }

    private fun validateRange(input: Int) {
        val rounds = input.toInt()
        require(rounds in MIN_ROUNDS..MAX_ROUNDS) { INVALID_RANGE_ERROR }
    }

    companion object {
        private fun validateUserInput(input: String): Int {
            checkEmpty(input)
            checkNumeric(input)
            return input.toInt()
        }

        private fun checkEmpty(input: String) {
            require(input.isNotBlank()) { EMPTY_INPUT_ERROR }
        }

        private fun checkNumeric(input: String) {
            require(input.toIntOrNull() != null) { NOT_NUMERIC_ERROR }
        }

        fun from(input: String): Rounds {
            val value = validateUserInput(input)
            return Rounds(value)
        }

        operator fun invoke(input: String): Rounds = from(input)

        private const val EMPTY_INPUT_ERROR = "$ERROR 빈 값을 입력하셨습니다."
        private const val NOT_NUMERIC_ERROR = "$ERROR 숫자를 입력해야 합니다."
        private const val INVALID_RANGE_ERROR = "$ERROR 1에서 10 사이의 수를 입력해야 합니다."

        private const val MIN_ROUNDS = 1
        private const val MAX_ROUNDS = 10
    }
}

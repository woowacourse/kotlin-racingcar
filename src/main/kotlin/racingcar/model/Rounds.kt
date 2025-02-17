package racingcar.model

import racingcar.util.ErrorConstants.ERROR

@JvmInline
value class Rounds private constructor(val value: Int) {
    init {
        validate(value)
    }

    private fun validate(value: Int) {
        validateRange(value)
    }

    private fun validateRange(value: Int) {
        require(value in MIN_ROUNDS..MAX_ROUNDS) { INVALID_RANGE_ERROR }
    }

    companion object {
        private fun validNumericValue(value: String) {
            checkEmpty(value)
            checkNumeric(value)
        }

        private fun checkEmpty(value: String) {
            require(value.isNotBlank()) { EMPTY_INPUT_ERROR }
        }

        private fun checkNumeric(value: String) {
            require(value.toIntOrNull() != null) { NOT_NUMERIC_ERROR }
        }

        fun from(value: String): Rounds {
            validNumericValue(value)
            val numericValue = value.toInt()
            return Rounds(numericValue)
        }

        operator fun invoke(input: String): Rounds = from(input)

        private const val EMPTY_INPUT_ERROR = "$ERROR 빈 값을 입력하셨습니다."
        private const val NOT_NUMERIC_ERROR = "$ERROR 숫자를 입력해야 합니다."
        private const val INVALID_RANGE_ERROR = "$ERROR 1에서 10 사이의 수를 입력해야 합니다."

        private const val MIN_ROUNDS = 1
        private const val MAX_ROUNDS = 10
    }
}

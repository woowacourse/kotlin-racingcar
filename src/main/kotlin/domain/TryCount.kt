package domain

class TryCount private constructor(val count: Int) {
    companion object {
        fun from(input: String) =
            validateCount(input)
                .run { TryCount(this) }

        private fun validateCount(input: String): Int {
            val count = input.toIntOrNull()
            requireNotNull(count) { EXCEPTION_TRY_COUNT_IS_NOT_INT }
            require(count > 0) { EXCEPTION_INVALID_TRY_COUNT_RANGE }
            return count
        }
    }
}

private const val EXCEPTION_TRY_COUNT_IS_NOT_INT = "시도 횟수는 정수여야 합니다"
private const val EXCEPTION_INVALID_TRY_COUNT_RANGE = "시도 횟수는 0보다 큰 수여야 합니다"

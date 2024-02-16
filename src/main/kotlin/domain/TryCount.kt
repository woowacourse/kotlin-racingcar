package domain

class TryCount private constructor(val count: Int) {
    companion object {
        fun from(input: String) =
            input.isValidCount()
                .run { TryCount(this) }
    }
}

fun String.isValidCount(): Int {
    val count = this.toIntOrNull()
    requireNotNull(count) { EXCEPTION_TRY_COUNT_IS_NOT_INT }
    require(count > 0) { EXCEPTION_INVALID_TRY_COUNT_RANGE }
    return count
}

const val EXCEPTION_TRY_COUNT_IS_NOT_INT = "시도 횟수는 정수여야 합니다"
const val EXCEPTION_INVALID_TRY_COUNT_RANGE = "시도 횟수는 0보다 큰 수여야 합니다"

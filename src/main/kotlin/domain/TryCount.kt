package domain

class TryCount private constructor(val count: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TryCount

        if (count != other.count) return false

        return true
    }

    override fun hashCode(): Int {
        return count
    }

    override fun toString(): String {
        return "TryCount(count=$count)"
    }

    companion object {
        fun from(input: String) =
            input.isValidCount()
                .run { TryCount(this) }
    }
}

private fun String.isValidCount(): Int {
    val count = this.toIntOrNull()
    requireNotNull(count) { EXCEPTION_TRY_COUNT_IS_NOT_INT }
    require(count > 0) { EXCEPTION_INVALID_TRY_COUNT_RANGE }
    return count
}

private const val TRY_COUNT_IS_GREATER_THAN = 0
private const val EXCEPTION_TRY_COUNT_IS_NOT_INT = "시도 횟수는 정수여야 합니다"
private const val EXCEPTION_INVALID_TRY_COUNT_RANGE = "시도 횟수는 $TRY_COUNT_IS_GREATER_THAN 보다 큰 수여야 합니다"

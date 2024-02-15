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
    requireNotNull(count) { "시도 횟수는 정수여야 합니다" }
    require(count > 0) { "시도 횟수는 0보다 큰 수여야 합니다" }
    return count
}


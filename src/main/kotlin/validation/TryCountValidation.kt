package validation

class TryCountValidation {
    fun checkTryCount(tryCount: String) {
        checkTryCountInteger(tryCount)
        checkTryCountPositive(tryCount)
    }

    fun checkTryCountInteger(tryCount: String) {
        tryCount.toIntOrNull() ?: throw IllegalArgumentException(TRY_COUNT_INTEGER_ERROR_MESSAGE)
    }

    fun checkTryCountPositive(tryCount: String) {
        if (tryCount.toInt() < MINIMUM_POSITIVE_NUMBER)
            throw IllegalArgumentException(TRY_COUNT_POSITIVE_ERROR_MESSAGE)
    }

    companion object{
        const val MINIMUM_POSITIVE_NUMBER = 1
        const val TRY_COUNT_INTEGER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자만 입력해 주세요"
        const val TRY_COUNT_POSITIVE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양의 정수여야 합니다"
    }
}

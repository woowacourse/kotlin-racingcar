package validation

import message.ExceptionMessage

class TryCountValidation {
    fun checkTryCount(tryCount: String) {
        checkTryCountInteger(tryCount)
        checkTryCountPositive(tryCount)
    }

    fun checkTryCountInteger(tryCount: String) {
        try {
            tryCount.toInt()
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(ExceptionMessage.TRY_COUNT_INTEGER_ERROR_MESSAGE)
        }
    }

    fun checkTryCountPositive(tryCount: String) {
        if (tryCount.toInt() < MINIMUM_TRY_COUNT)
            throw IllegalArgumentException(ExceptionMessage.TRY_COUNT_POSITIVE_ERROR_MESSAGE)
    }

    companion object {
        const val MINIMUM_TRY_COUNT = 1
    }
}

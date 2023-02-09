package exception

import message.ExceptionMessage

class TryCountException {
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
        if (tryCount.toInt() <= 0)
            throw IllegalArgumentException(ExceptionMessage.TRY_COUNT_POSITIVE_ERROR_MESSAGE)
    }
}

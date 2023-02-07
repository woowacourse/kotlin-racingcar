package exception

import message.ExceptionMessage

class TryCountException(tryCount: String) {
    init {
        checkTryCountInteger(tryCount)
        checkTryCountPositive(tryCount)
    }

    private fun checkTryCountInteger(tryCount: String) {
        try {
            tryCount.toInt()
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(ExceptionMessage.TRY_COUNT_INTEGER_ERROR_MESSAGE)
        }
    }

    private fun checkTryCountPositive(tryCount: String) {
        if (tryCount.toInt() < 0)
            throw IllegalArgumentException(ExceptionMessage.TRY_COUNT_POSITIVE_ERROR_MESSAGE)
    }
}

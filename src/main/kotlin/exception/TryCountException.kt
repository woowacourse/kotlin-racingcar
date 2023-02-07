package exception

import message.ExceptionMessage

class TryCountException(tryCount: String) {
    init {
        checkTryCountInteger(tryCount)
    }

    private fun checkTryCountInteger(tryCount: String) {
        try {
            tryCount.toInt()
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(ExceptionMessage.TRY_COUNT_INTEGER_ERROR_MESSAGE)
        }
    }
}

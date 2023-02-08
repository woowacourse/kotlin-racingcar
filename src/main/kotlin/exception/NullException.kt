package exception

import message.ExceptionMessage

class NullException(input: String?) {
    init {
        checkNull(input)
    }

    private fun checkNull(input: String?) {
        if (input.isNullOrBlank())
            throw IllegalArgumentException(ExceptionMessage.INPUT_IS_EMPTY_ERROR_MESSAGE)
    }
}

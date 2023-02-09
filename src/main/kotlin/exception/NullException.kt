package exception

import message.ExceptionMessage

class NullException {

    fun checkNull(input: String?): String {
        if (input.isNullOrBlank())
            throw IllegalArgumentException(ExceptionMessage.INPUT_IS_EMPTY_ERROR_MESSAGE)
        return input
    }
}

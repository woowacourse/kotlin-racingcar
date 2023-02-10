package validation

import message.ExceptionMessage

class NullValidation {

    fun checkNull(input: String?): String {
        if (input.isNullOrBlank())
            throw IllegalArgumentException(ExceptionMessage.INPUT_IS_EMPTY_ERROR_MESSAGE)
        return input
    }
}

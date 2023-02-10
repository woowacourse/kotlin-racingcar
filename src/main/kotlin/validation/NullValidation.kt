package validation

object NullValidation {

    fun checkNull(input: String?): String {
        if (input.isNullOrBlank())
            throw IllegalArgumentException(INPUT_IS_EMPTY_ERROR_MESSAGE)
        return input
    }

    private const val INPUT_IS_EMPTY_ERROR_MESSAGE = "[ERROR] 아무것도 입력하지 않았습니다."
}

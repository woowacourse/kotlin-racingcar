package validation

object NullOrBlankValidation {
    private const val INPUT_IS_EMPTY_ERROR_MESSAGE = "[ERROR] 아무것도 입력하지 않았습니다."

    fun checkNullOrBlank(input: String?): String {
        require(!input.isNullOrBlank()) {
            INPUT_IS_EMPTY_ERROR_MESSAGE
        }
        return input
    }
}

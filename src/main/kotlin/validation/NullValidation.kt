package validation

class NullValidation {

    fun checkNull(input: String?): String {
        require(!input.isNullOrBlank()) { INPUT_IS_EMPTY_ERROR_MESSAGE }
        return input
    }

    companion object {
        const val INPUT_IS_EMPTY_ERROR_MESSAGE = "[ERROR] 아무것도 입력하지 않았습니다."
    }
}

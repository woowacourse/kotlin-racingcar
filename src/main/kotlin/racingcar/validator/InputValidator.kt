package racingcar.validator

object InputValidator {
    fun validateNotEmpty(input: String) {
        require(input.isNotBlank()) { EMPTY_INPUT_ERROR }
    }

    private const val ERROR = "[ERROR]"
    const val EMPTY_INPUT_ERROR = "$ERROR 빈 값을 입력하셨습니다."
}

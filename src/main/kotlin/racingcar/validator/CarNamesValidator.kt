package racingcar.validator

class CarNamesValidator {
    fun validate(input: String) {
        isNotEmpty(input)
        val carNames = input.split(COMMA)
        isValidLength(carNames)
    }

    private fun isNotEmpty(carName: String) {
        require(carName.isNotBlank()) { EMPTY_INPUT_ERROR }
    }

    private fun isValidLength(carNames: List<String>) {
        require(carNames.all { it.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH }) { INVALID_NAME_LENGTH_ERROR }
    }

    companion object {
        private const val ERROR = "[ERROR]"
        const val EMPTY_INPUT_ERROR = "$ERROR 빈 값을 입력하셨습니다."
        const val INVALID_NAME_LENGTH_ERROR = "$ERROR 이름은 1~5자이어야 합니다."

        const val COMMA = ','
        const val MIN_NAME_LENGTH = 1
        const val MAX_NAME_LENGTH = 5
    }
}

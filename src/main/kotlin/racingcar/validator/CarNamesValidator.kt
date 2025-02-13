package racingcar.validator

class CarNamesValidator {
    fun validate(input: String): List<String> {
        isNotEmpty(input)
        val carNames = input.split(COMMA).map { it.trim() }
        isValidLength(carNames)
        isValidFormat(carNames)
        isUniqueName(carNames)
        return carNames
    }

    private fun isNotEmpty(carName: String) {
        require(carName.isNotBlank()) { EMPTY_INPUT_ERROR }
    }

    private fun isValidLength(carNames: List<String>) {
        require(carNames.all { it.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH }) { INVALID_NAME_LENGTH_ERROR }
    }

    private fun isValidFormat(carNames: List<String>) {
        require(carNames.all { it.matches(regex) }) { INVALID_NAME_FORMAT_ERROR }
    }

    private fun isUniqueName(carNames: List<String>) {
        require(carNames.size == carNames.distinct().size) { NOT_UNIQUE_NAME_ERROR }
    }

    companion object {
        private const val ERROR = "[ERROR]"
        const val EMPTY_INPUT_ERROR = "$ERROR 빈 값을 입력하셨습니다."
        const val INVALID_NAME_LENGTH_ERROR = "$ERROR 자동차 이름은 1~5자이어야 합니다."
        const val INVALID_NAME_FORMAT_ERROR = "$ERROR 자동차 이름은 영문 또는 숫자로 이루어져야 합니다."
        const val NOT_UNIQUE_NAME_ERROR = "$ERROR 자동차 이름이 중복됩니다."

        const val COMMA = ","
        const val MIN_NAME_LENGTH = 1
        const val MAX_NAME_LENGTH = 5

        private val regex = Regex("^[a-zA-Z0-9]*\$")
    }
}

package racingcar.validator

class CarNamesValidator {
    fun validate(input: String): List<String> {
        isNotEmpty(input)
        val carNames = input.split(COMMA).map { it.trim() }
        isUniqueName(carNames)
        return carNames
    }

    private fun isNotEmpty(carName: String) {
        require(carName.isNotBlank()) { EMPTY_INPUT_ERROR }
    }

    private fun isUniqueName(carNames: List<String>) {
        require(carNames.size == carNames.distinct().size) { NOT_UNIQUE_NAME_ERROR }
    }

    companion object {
        private const val ERROR = "[ERROR]"
        const val EMPTY_INPUT_ERROR = "$ERROR 빈 값을 입력하셨습니다."
        const val NOT_UNIQUE_NAME_ERROR = "$ERROR 자동차 이름이 중복됩니다."

        const val COMMA = ","
    }
}

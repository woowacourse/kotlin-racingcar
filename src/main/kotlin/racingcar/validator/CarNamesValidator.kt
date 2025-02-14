package racingcar.validator

class CarNamesValidator {
    fun validate(input: String): List<String> {
        isNotEmpty(input)
        val carNames = input.split(COMMA).map { it.trim() }
        return carNames
    }

    private fun isNotEmpty(carName: String) {
        require(carName.isNotBlank()) { EMPTY_INPUT_ERROR }
    }

    companion object {
        private const val ERROR = "[ERROR]"
        const val EMPTY_INPUT_ERROR = "$ERROR 빈 값을 입력하셨습니다."

        const val COMMA = ","
    }
}

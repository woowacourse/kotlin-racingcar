package racingcar.validator

class RoundsValidator {
    fun validate(input: String): Int {
        isNotEmpty(input)
        return 0
    }

    private fun isNotEmpty(carName: String) {
        require(carName.isNotBlank()) { EMPTY_INPUT_ERROR }
    }

    companion object {
        private const val ERROR = "[ERROR]"
        const val EMPTY_INPUT_ERROR = "$ERROR 빈 값을 입력하셨습니다."
    }
}

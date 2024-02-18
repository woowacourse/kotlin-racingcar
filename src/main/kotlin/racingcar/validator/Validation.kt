package racingcar.validator

class Validation {
    fun carName(name: String) {
        require(name.isNotEmpty()) { ERROR_CAR_NAME_BLANK }
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) { ERROR_CAR_NAME_OUT_OF_RANGE }
        require(!name.contains(SPACE)) { ERROR_CAR_NAME_CONTAINS_SPACE }
    }

    fun carNameList(names: List<String>) {
        require(names.isNotEmpty()) { ERROR_REQUEST_INPUT }
        require(names.size >= MIN_NAMES_SIZE) { ERROR_CAR_LESS_THAN_TWO }
        require(names.size <= MAX_NAMES_SIZE) { ERROR_CAR_GREATER_THAN_TWENTY }
        require(names.distinct().size == names.size) { ERROR_NAME_DUPLICATION }
    }

    fun roundNumber(roundNumberInput: String) {
        require(isNumber(roundNumberInput)) { ERROR_INPUT_NUMBER_ONLY }
        require(roundNumberInput.isNotEmpty()) { ERROR_REQUEST_INPUT }

        val roundNumber = roundNumberInput.toInt()
        require(roundNumber >= MIN_ROUND_NUMBER) { ERROR_ROUND_LESS_THAN_ONE }
    }

    private fun isNumber(number: String): Boolean {
        return try {
            number.toInt()
            true
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_INPUT_NUMBER_ONLY)
        }
    }

    companion object {
        private const val ERROR_REQUEST_INPUT = "[Error] 값을 입력해 주세요"
        private const val ERROR_CAR_LESS_THAN_TWO = "[Error] 자동차 이름은 2대 이상 입력해 주세요."
        private const val ERROR_CAR_GREATER_THAN_TWENTY = "[Error] 자동차 이름은 20대 이하로 입력해 주세요."
        private const val ERROR_NAME_DUPLICATION = "[Error] 중복된 자동차 이름은 작성할 수 없습니다."
        private const val ERROR_ROUND_LESS_THAN_ONE = "[Error] 1회 이상 입력해 주세요."
        private const val ERROR_INPUT_NUMBER_ONLY = "[Error] 숫자만 입력해 주세요."

        private const val ERROR_CAR_NAME_BLANK = "[Error] 자동차 이름은 공란일 수 없습니다."
        const val ERROR_CAR_NAME_OUT_OF_RANGE = "[Error] 자동차 이름은 1자 이상 5자 이내여야 합니다."
        private const val ERROR_CAR_NAME_CONTAINS_SPACE = "[Error] 이름에 공백이 없어야 합니다."

        private const val SPACE = " "

        private const val MIN_NAME_LENGTH = 1
        private const val MAX_NAME_LENGTH = 5
        private const val MIN_NAMES_SIZE = 2
        private const val MAX_NAMES_SIZE = 20
        private const val MIN_ROUND_NUMBER = 1
    }
}

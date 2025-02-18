object InputValidator {
    private const val ERROR_EMPTY_CAR_NAME_MESSAGE = "[ERROR] 자동차 이름은 공백일 수 없습니다."
    private const val ERROR_DUPLICATED_CAR_NAME_MESSAGE = "[ERROR] 중복된 자동차 이름이 있습니다."
    private const val ERROR_OUT_OF_BOUND_CAR_NAME_MESSAGE = "[ERROR] 자동차 이름의 최대 길이를 초과했습니다."
    private const val ERROR_EMPTY_TRY_COUNT_MESSAGE = "[ERROR] 시도횟수는 공백일 수 없습니다."
    private const val ERROR_IS_NOT_NUMBER_MESSAGE = "[ERROR] 시도횟수는 숫자여야만 합니다."
    private const val ERROR_OUT_OF_BOUND_TRY_COUNT_MESSAGE = "[ERROR] 시도횟수는 1에서 1,000 사이의 숫자여야 합니다."

    fun validateName(input: String) {
        require(input.isNotBlank()) { ERROR_EMPTY_CAR_NAME_MESSAGE }
        val carNames = input.split(",").map { it.trim() }
        carNames.forEach { validateNameLength(it) }
        require(validateDuplicatedName(carNames)) { ERROR_DUPLICATED_CAR_NAME_MESSAGE }
    }

    private fun validateNameLength(input: String) {
        require(input.length in 1..5) { ERROR_OUT_OF_BOUND_CAR_NAME_MESSAGE }
    }

    private fun validateDuplicatedName(input: List<String>): Boolean {
        return input.distinct().size == input.size
    }

    fun validateTryCount(input: String) {
        require(input.isNotBlank()) { ERROR_EMPTY_TRY_COUNT_MESSAGE }
        require(input.toIntOrNull() != null) { ERROR_IS_NOT_NUMBER_MESSAGE }
        require(input.toIntOrNull() in 1..1000) { ERROR_OUT_OF_BOUND_TRY_COUNT_MESSAGE }
    }
}

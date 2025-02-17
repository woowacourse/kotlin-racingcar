package validator

object InputValidator {
    fun validateCarName(inputCarName: String) {
        require(inputCarName.length <= NAME_LENGTH_LIMIT) { "각 자동차 이름은 5자를 초과할 수 없습니다." }
        require(inputCarName.isNotBlank()) { "각 자동차 이름은 공백이 불가합니다." }
    }

    fun validateTryNumber(inputTryNumber: String): Int {
        require(inputTryNumber.all { it.isDigit() }) { "시도 횟수는 숫자로 입력해주세요." }
        require(inputTryNumber.toInt() > MIN_TRY_NUMBER) { "시도 횟수는 0보다 커야 합니다." }
        return inputTryNumber.toInt()
    }

    private const val NAME_LENGTH_LIMIT = 5
    private const val MIN_TRY_NUMBER = 0
}

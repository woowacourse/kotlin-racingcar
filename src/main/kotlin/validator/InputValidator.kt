package validator

object InputValidator {
    fun validateCarNames(splitCarNames: List<String>) {
        require(splitCarNames.all { it.length <= 5 }) { "각 자동차 이름은 5자를 초과할 수 없습니다." }
        require(splitCarNames.all { it.isNotBlank() }) { "각 자동차 이름은 공백이 불가합니다." }
        require(splitCarNames.size == splitCarNames.toSet().size) { "각 자동차 이름은 중복이 불가합니다." }
    }

    fun validateTryNumber(inputTryNumber: String): Int {
        require(inputTryNumber.all { it.isDigit() }) { "시도 횟수는 숫자로 입력해주세요." }
        require(inputTryNumber.toInt() > 0) { "시도 횟수는 0보다 커야 합니다." }
        return inputTryNumber.toInt()
    }
}

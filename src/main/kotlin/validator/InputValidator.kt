package validator

object InputValidator {
    fun validateDuplicatedName(splitCarNames: List<String>) {
        require(splitCarNames.size == splitCarNames.toSet().size) { "자동차 이름은 중복될 수 없습니다." }
    }

    fun validateTryNumber(inputTryNumber: String): Int {
        require(inputTryNumber.all { it.isDigit() }) { "잘못 입력된 시도 횟수 -> $inputTryNumber : 시도 횟수는 숫자로 입력해주세요." }
        require(inputTryNumber.toInt() > 0) { "잘못 입력된 시도 횟수 -> $inputTryNumber : 시도 횟수는 0보다 커야 합니다." }
        return inputTryNumber.toInt()
    }
}

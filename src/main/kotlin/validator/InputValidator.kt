package validator

object InputValidator {
    fun validateTryNumber(inputTryNumber: String): Int {
        require(inputTryNumber.all { it.isDigit() }) { "시도 횟수는 숫자로 입력해주세요." }
        require(inputTryNumber.toInt() > 0) { "시도 횟수는 0보다 커야 합니다." }
        return inputTryNumber.toInt()
    }
}

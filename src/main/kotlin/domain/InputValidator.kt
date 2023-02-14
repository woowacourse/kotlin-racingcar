package domain

object InputValidator {

    private const val NUMERIC_ERROR_MSG = "[ERROR] 시도 횟수는 숫자 입력으로만 받습니다."

    fun validateIsNumeric(numberOfTry: String): Int {
        require(numberOfTry.isNumeric()) {
            NUMERIC_ERROR_MSG
        }
        return numberOfTry.toInt()
    }

    private fun String.isNumeric(): Boolean {
        return this.chars().allMatch { Character.isDigit(it) }
    }
}

object InputValidator {

    fun validateIsNumeric(numberOfTry: String) {
        require(numberOfTry.isNumeric()) {
            "[ERROR] 시도 횟수는 숫자 입력으로만 받습니다."
        }
    }

    private fun String.isNumeric(): Boolean {
        return this.chars().allMatch { Character.isDigit(it) }
    }
}

class InputValidator {

    fun validateNameLength(name: String) {
        require(name.length <= 5) {
            "[ERROR] 자동차 이름은 5자를 초과할 수 없다."
        }
    }

    fun validateIsNumeric(numberOfTry: String) {
        require(numberOfTry.isNumeric()) {
            "[ERROR] 시도 횟수는 숫자 입력으로만 받습니다."
        }
    }

    private fun String.isNumeric(): Boolean {
        return this.chars().allMatch { Character.isDigit(it) }
    }
}

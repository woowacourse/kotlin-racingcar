package racing.validators

object UserInputValidator {

    private const val PREFIX = "[Error]"

    fun validateUserCarNameLength(userInput: String) {
        require(userInput.length <= 5) { "$PREFIX 자동차 이름은 5글자까지 가능합니다." }
    }

    fun validateUserCarNameBlank(userInput: String) {
        require(userInput.isNotEmpty()) { "$PREFIX 자동차 이름은 빈값이 될 수 없습니다." }
    }
}

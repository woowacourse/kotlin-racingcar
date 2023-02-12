package racing.validators

object CarNameValidator {

    private const val PREFIX = "[Error]"

    fun validateUserCarNameLength(carName: String) {
        require(carName.length <= 5) { "$PREFIX 자동차 이름은 5글자까지 가능합니다." }
    }

    fun validateUserCarNameBlank(carName: String) {
        require(carName.isNotEmpty()) { "$PREFIX 자동차 이름은 빈값이 될 수 없습니다." }
    }
}

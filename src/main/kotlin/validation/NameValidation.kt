package validation

class NameValidation {
    private val nullException = NullValidation()
    fun checkNames(carNames: String) {
        splitCarNames(carNames).forEach { name ->
            checkNameRange(nullException.checkNull(name))
            checkCarNameEnglishNumber(name)
        }
    }

    fun checkNameRange(carName: String) = require(carName.length <= MAXIMUM_NAME_LENGTH) { NAME_RANGE_ERROR_MASSAGE }

    private fun splitCarNames(carNames: String): List<String> {
        return carNames.split(",")
    }

    fun checkCarNameEnglishNumber(carName: String) {
        if (!Regex(ONLY_ENGLISH_NUMBER_REGEX).matches(carName))
            throw IllegalArgumentException(NAME_IS_ONLY_ENGLISH_AND_NUMBER)
    }

    companion object {
        const val NAME_IS_ONLY_ENGLISH_AND_NUMBER = "[ERROR] 이름은 영어와 숫자만 가능합니다."
        const val NAME_RANGE_ERROR_MASSAGE = "[ERROR] 자동차 이름은 1자 이상 5자 이하로 입력해주세요"
        const val ONLY_ENGLISH_NUMBER_REGEX = "^[a-zA-Z0-9]*\$"
        const val MAXIMUM_NAME_LENGTH = 5
    }
}

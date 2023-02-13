package validation

import view.OutputView

object NameValidation {
    private const val MAXIMUM_CAR_NAME_LENGTH = 5
    private const val REGEX_ONLY_ENGLISH_AND_NUMBER = "^[a-zA-Z0-9]*\$"

    private const val NAME_IS_ONLY_ENGLISH_AND_NUMBER = "[ERROR] 이름은 영어와 숫자만 가능합니다."
    private const val NAME_RANGE_ERROR_MASSAGE = "[ERROR] 자동차 이름은 1자 이상 5자 이하로 입력해주세요"

    fun validateCarName(input: String): Boolean = try {
        NullOrBlankValidation.checkNullOrBlank(input)
        checkNames(input)
        true
    } catch (e: IllegalArgumentException) {
        OutputView.printMessage(e.message!!)
        false
    }

    private fun checkNames(carNames: String) {
        splitCarNames(carNames).forEach { name ->
            checkNameRange(name)
            checkCarNameEnglishNumber(name)
        }
    }

    fun checkNameRange(carName: String) {
        require(carName.isNotEmpty() && carName.length <= MAXIMUM_CAR_NAME_LENGTH) {
            NAME_RANGE_ERROR_MASSAGE
        }
    }

    private fun splitCarNames(carNames: String): List<String> {
        return carNames.split(",")
    }

    fun checkCarNameEnglishNumber(carName: String) {
        require(Regex(REGEX_ONLY_ENGLISH_AND_NUMBER).matches(carName)) {
            NAME_IS_ONLY_ENGLISH_AND_NUMBER
        }
    }
}

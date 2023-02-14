package validation

import model.Name

class NameValidation {
    fun checkNames(carNames: String?): Result<Name> {
        if (carNames.isNullOrBlank()) return Result.failure(IllegalArgumentException(INPUT_IS_EMPTY_ERROR_MESSAGE))
        splitCarNames(carNames).forEach { name ->
            if (isNameLengthExceed(name)) return Result.failure(IllegalArgumentException(NAME_RANGE_ERROR_MASSAGE))
            if (!isCarNameEnglishNumber(name)) return Result.failure(IllegalArgumentException(NAME_IS_ONLY_ENGLISH_AND_NUMBER))
        }
        return Result.success(Name(carNames))
    }

    fun isNameLengthExceed(carName: String) = carName.length > MAXIMUM_NAME_LENGTH

    fun splitCarNames(carNames: String): List<String> {
        return carNames.split(",")
    }

    fun isCarNameEnglishNumber(carName: String) = Regex(ONLY_ENGLISH_NUMBER_REGEX).matches(carName)

    companion object {
        const val NAME_IS_ONLY_ENGLISH_AND_NUMBER = "[ERROR] 이름은 영어와 숫자만 가능합니다."
        const val NAME_RANGE_ERROR_MASSAGE = "[ERROR] 자동차 이름은 1자 이상 5자 이하로 입력해주세요"
        const val ONLY_ENGLISH_NUMBER_REGEX = "^[a-zA-Z0-9]*\$"
        const val MAXIMUM_NAME_LENGTH = 5
        const val INPUT_IS_EMPTY_ERROR_MESSAGE = "[ERROR] 아무것도 입력하지 않았습니다."
    }
}

package model

import validation.NameValidation

data class Name(val name: String) {

    private val nameValidation = NameValidation()

    init {
        require(!name.isNullOrBlank()) { NAME_RANGE_ERROR_MASSAGE }
        val carNames = nameValidation.splitCarNames(name)
        carNames.forEach { carName ->
            require(!nameValidation.isNameLengthExceed(carName)) { NAME_RANGE_ERROR_MASSAGE }
            require(nameValidation.isCarNameEnglishNumber(carName)) { NAME_IS_ONLY_ENGLISH_AND_NUMBER }
        }
    }

    companion object {
        const val NAME_IS_ONLY_ENGLISH_AND_NUMBER = "[ERROR] 이름은 영어와 숫자만 가능합니다."
        const val NAME_RANGE_ERROR_MASSAGE = "[ERROR] 자동차 이름은 1자 이상 5자 이하로 입력해주세요"
    }
}

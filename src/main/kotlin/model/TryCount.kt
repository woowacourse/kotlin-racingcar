package model

import validation.TryCountValidation

data class TryCount(val tryCount: String) {
    val tryCountValidation = TryCountValidation()

    init {
        require(!tryCount.isNullOrBlank()) { INPUT_IS_EMPTY_ERROR_MESSAGE }
        require(tryCountValidation.isTryCountInteger(tryCount)) { TRY_COUNT_INTEGER_ERROR_MESSAGE }
        require(tryCountValidation.isTryCountPositive(tryCount)) { TRY_COUNT_POSITIVE_ERROR_MESSAGE }
    }

    companion object {
        const val INPUT_IS_EMPTY_ERROR_MESSAGE = "[ERROR] 아무것도 입력하지 않았습니다."
        const val TRY_COUNT_INTEGER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자만 입력해 주세요"
        const val TRY_COUNT_POSITIVE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양의 정수여야 합니다"
    }
}

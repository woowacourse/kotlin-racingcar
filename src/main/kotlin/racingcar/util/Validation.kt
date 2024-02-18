package racingcar.util

object Validation {
    const val TRY_COUNT_NOT_NUMERIC_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자로 입력되어야합니다."
    const val TRY_COUNT_RANGE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양수로 입력되어야합니다."
    const val MINIMUM_TRY_COUNT = 1

    fun checkTryCnt(tryCnt: String) {
        checkIsNum(tryCnt)
        checkIsPositiveNum(tryCnt.toInt())
    }

    fun checkIsNum(tryCnt: String) {
        try {
            tryCnt.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(TRY_COUNT_NOT_NUMERIC_ERROR_MESSAGE)
        }
    }

    fun checkIsPositiveNum(tryCnt: Int) {
        require(tryCnt >= MINIMUM_TRY_COUNT) {
            TRY_COUNT_RANGE_ERROR_MESSAGE
        }
    }
}

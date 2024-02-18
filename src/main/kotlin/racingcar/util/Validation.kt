package racingcar.util

object Validation {
    const val TRY_COUNT_NOT_NUMERIC_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자로 입력되어야합니다."
    const val TRY_COUNT_RANGE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양수로 입력되어야합니다."
    const val MINIMUM_TRY_COUNT = 1
    const val CAR_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름의 길이는 최대 5글자입니다."
    const val CAR_NAME_SPLIT_ERROR_MESSAGE = "[ERROR] 자동차 이름은 쉼표(,)로 구분되어야합니다."
    const val CAR_NAME_LENGTH_MAX = 5
    const val SPLITTER = ","

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

    fun checkCarName(carsName: String) {
        checkSplit(carsName)

        val splitCarNames = carsName.split(SPLITTER)
        for (carName in splitCarNames) {
            checkNameLength(carName)
        }
    }

    fun checkSplit(names: String) {
        require(names.contains(SPLITTER)) {
            CAR_NAME_SPLIT_ERROR_MESSAGE
        }
    }

    fun checkNameLength(name: String) {
        require(name.length <= CAR_NAME_LENGTH_MAX) {
            CAR_NAME_LENGTH_ERROR_MESSAGE
        }
    }
}

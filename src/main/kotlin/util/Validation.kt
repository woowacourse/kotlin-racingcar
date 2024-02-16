package util

object Validation {

    private const val CAR_NAME_SPLITTER = ","
    private const val SPLITTER_ERROR_MESSAGE = "[ERROR] 자동차 이름은 쉼표(,)를 기준으로 구분해주세요."
    private const val CAR_NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자 이하여야 합니다."
    private const val CAR_NAME_MIN_LENGTH = 1
    private const val CAR_NAME_MAX_LENGTH = 5
    private const val CAR_NAME_DUPLICATE_ERROR_MESSAGE = "[ERROR] 자동차 이름은 중복될 수 없습니다."
    private const val ATTEMPT_COUNT_NOT_INT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 합니다."
    private const val MINIMUM_ATTEMPT_COUNT = 1
    private const val ATTEMPT_COUNT_RANGE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양수여야 합니다."

    fun carsName(carsName: String) {
        checkSplitter(carsName)

        val splittedCarsName = carsName.split(CAR_NAME_SPLITTER)
        checkNameDuplication(splittedCarsName)
        for (carName in splittedCarsName) {
            checkNameLength(carName)
        }
    }

    fun attemptCount(attemptCount: String) {
        checkIsNum(attemptCount)
        checkIsPositiveNum(attemptCount.toInt())
    }


    private fun checkSplitter(carsName: String) {
        require(carsName.contains(CAR_NAME_SPLITTER)) { SPLITTER_ERROR_MESSAGE }
    }

    private fun checkNameLength(carName: String) {
        require(carName.length in CAR_NAME_MIN_LENGTH..CAR_NAME_MAX_LENGTH) { CAR_NAME_LENGTH_ERROR_MESSAGE }
    }

    private fun checkNameDuplication(carsName: List<String>) {
        require(carsName.size == carsName.toSet().size) {
            CAR_NAME_DUPLICATE_ERROR_MESSAGE
        }
    }

    private fun checkIsNum(attemptCount: String) {
        try {
            attemptCount.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ATTEMPT_COUNT_NOT_INT_ERROR_MESSAGE)
        }
    }

    private fun checkIsPositiveNum(attemptCount: Int) {
        require(attemptCount >= MINIMUM_ATTEMPT_COUNT) { ATTEMPT_COUNT_RANGE_ERROR_MESSAGE }
    }
}

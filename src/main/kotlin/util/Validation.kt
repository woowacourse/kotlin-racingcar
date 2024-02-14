package util

object Validation {
    fun carsName(carsName: String) {
        checkSplitter(carsName)

        val splittedCarsName = carsName.split(",")
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
        require(carsName.contains(",")) { "[ERROR] 자동차 이름은 쉼표(,)를 기준으로 구분해주세요." }
    }

    private fun checkNameLength(carName: String) {
        require(carName.length <= 5) { "[ERROR] 자동차 이름은 5자 이하여야 합니다." }
    }

    private fun checkNameDuplication(carsName: List<String>) {
        require(carsName.size == carsName.toSet().size) {
            "[ERROR] 자동차 이름은 중복될 수 없습니다."
        }
    }

    private fun checkIsNum(attemptCount: String) {
        try {
            attemptCount.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.")
        }
    }

    private fun checkIsPositiveNum(attemptCount: Int) {
        require(attemptCount > 0) { "[ERROR] 시도 횟수는 양수여야 합니다." }
    }
}
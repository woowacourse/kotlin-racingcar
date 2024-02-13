package util

object Validation {
    fun carsName(carsName: String) {
        checkSplitter(carsName)
        for (carName in carsName.split(",")) {
            checkNameLength(carName)
        }
    }

    private fun checkSplitter(carsName: String) {
        require(carsName.contains(",")) { "[ERROR] 자동차 이름은 쉼표(,)를 기준으로 구분해주세요." }
    }

    private fun checkNameLength(carName: String) {
        require(carName.length <= 5) { "[ERROR] 자동차 이름은 5자 이하여야 합니다." }
    }
}
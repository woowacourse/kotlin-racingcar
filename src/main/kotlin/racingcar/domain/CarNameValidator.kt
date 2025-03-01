package racingcar.domain

class CarNameValidator {
    fun validateCarName(carNames: List<String>) {
        if (isDuplicateCarNames(carNames) ||
            isEmptyCarNames(carNames) ||
            carNameLengthCheck(carNames)
        ) {
            throw IllegalArgumentException(CARNAME_ERROR_MESSAGE)
        }
    }

    private fun isDuplicateCarNames(carNames: List<String>): Boolean {
        return carNames.size != carNames.toSet().size
    }

    private fun isEmptyCarNames(carNames: List<String>): Boolean {
        carNames.forEach { carName ->
            return carName.isBlank()
        }
        return false
    }

    private fun carNameLengthCheck(carNames: List<String>): Boolean {
        carNames.forEach { carName ->
            return carName.length > CARNAME_MAX_LENGTH
        }
        return false
    }

    companion object {
        private const val CARNAME_ERROR_MESSAGE = "[ERROR] 자동차 이름을 다시 입력해주세요."
        private const val CARNAME_MAX_LENGTH = 5
    }
}

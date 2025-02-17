package racingcar.utils

class InputValidator {
    fun validateCarName(rawCarName: String) {
        val carNames = rawCarName.split(COMMA)
        if (isDuplicateCarNames(carNames) ||
            isEmptyCarNames(carNames) ||
            carNameLengthCheck(carNames)
        ) {
            throw IllegalArgumentException(CARNAME_ERROR_MESSAGE)
        }
    }

    fun validateTryCount(rawTryCount: String) {
        if (isTryCountNumeric(rawTryCount) || isEmptyTryCount(rawTryCount)) {
            throw IllegalArgumentException(
                TRYCOUNT_ERROR_MESSAGE,
            )
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

    private fun isTryCountNumeric(rawTryCount: String): Boolean {
        if (rawTryCount.toIntOrNull() == null) return true
        if (rawTryCount.toInt() <= 0) return true

        return false
    }

    private fun isEmptyTryCount(rawTryCount: String): Boolean {
        return rawTryCount.isBlank()
    }

    companion object {
        private const val COMMA = ","
        private const val CARNAME_ERROR_MESSAGE = "[ERROR] 자동차 이름을 다시 입력해주세요."
        private const val TRYCOUNT_ERROR_MESSAGE = "[ERROR] 시도횟수를 다시 입력해주세요."
        private const val CARNAME_MAX_LENGTH = 5
    }
}

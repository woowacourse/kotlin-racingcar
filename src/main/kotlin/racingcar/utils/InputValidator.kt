package racingcar.utils

class InputValidator {
    fun validateCarName(rawCarName: String) {
        val carNames = rawCarName.split(COMMA)
        if (carNames.duplicateCarNames() ||
            carNames.emptyCarNames() ||
            carNames.carNameLength()
        ) {
            throw IllegalArgumentException(CARNAME_ERROR_MESSAGE)
        }
    }

    fun validateTryCount(rawTryCount: String) {
        if (rawTryCount.toIntTryCount() || rawTryCount.emptyTryCount()) {
            throw IllegalArgumentException(
                TRYCOUNT_ERROR_MESSAGE,
            )
        }
    }

    private fun List<String>.duplicateCarNames(): Boolean {
        return this.size != this.toSet().size
    }

    private fun List<String>.emptyCarNames(): Boolean {
        this.forEach { carName ->
            return carName.isBlank()
        }
        return false
    }

    private fun List<String>.carNameLength(): Boolean {
        this.forEach { carName ->
            return carName.length > CARNAME_MAX_LENGTH
        }
        return false
    }

    private fun String.toIntTryCount(): Boolean {
        if (this.toIntOrNull() == null) return true
        if (this.toInt() <= 0) return true

        return false
    }

    private fun String.emptyTryCount(): Boolean {
        return this.isBlank()
    }

    companion object {
        private const val COMMA = ","
        private const val CARNAME_ERROR_MESSAGE = "[ERROR] 자동차 이름을 다시 입력해주세요."
        private const val TRYCOUNT_ERROR_MESSAGE = "[ERROR] 시도횟수를 다시 입력해주세요."
        private const val CARNAME_MAX_LENGTH = 5
    }
}

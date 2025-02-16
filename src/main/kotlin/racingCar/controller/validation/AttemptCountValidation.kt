package racingCar.controller.validation

class AttemptCountValidation (
    private val attemptCount: String,
) {
    fun validateAttemptCount() {
        isNotEmpty()
        isLong()
        isInteger()
        over1()
    }

    private fun isNotEmpty() {
        require(attemptCount.isNotEmpty()) { AttemptCountErrorType.EMPTY_INPUT.errorMessage }
    }

    private fun isLong() {
        require(attemptCount.toLongOrNull() != null) { AttemptCountErrorType.NO_LONG.errorMessage }
    }

    private fun isInteger() {
        require(attemptCount.toIntOrNull() != null) { AttemptCountErrorType.INTEGER.errorMessage }
    }

    private fun over1() {
        require(attemptCount.toInt() >= RACE_COUNT_OK) { AttemptCountErrorType.UP_1.errorMessage }
    }

    companion object {
        private const val RACE_COUNT_OK = 1
    }
}
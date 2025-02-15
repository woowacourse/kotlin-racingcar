package util

object Validator {
    fun validateCarName(input: List<String>) {
        require(input.all { it.isNotEmpty() && it.length <= Constants.CONDITION_CAR_MAX_LENGTH }) {
            IllegalArgumentException(Messages.MESSAGE_INVALID_CAR_NAME)
        }
    }

    fun validateCount(count: String) {
        require(count.toIntOrNull() != null) {
            IllegalArgumentException(Messages.MESSAGE_RACE_COUNT_NOT_INTEGER)
        }
    }
}

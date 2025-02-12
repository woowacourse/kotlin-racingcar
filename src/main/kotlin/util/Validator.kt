package util

object Validator {
    fun validateCarName(input: List<String>) {
        require(input.all { it.isNotEmpty() && it.length <= Constants.CONDITION_CAR_MAX_LENGTH }) {
            IllegalArgumentException(Messages.MESSAGE_INVALID_CAR_NAME)
        }
        require(input.size == input.toSet().size) {
            IllegalArgumentException(Messages.MESSAGE_DUPLICATE_CAR_NAME)
        }
    }

    fun validateCount(count: String) {
        require(count.toIntOrNull() != null) {
            IllegalArgumentException(Messages.MESSAGE_RACE_COUNT_NOT_INTEGER)
        }

        require(count.toInt() >= Constants.CONDITION_CAR_MIN_COUNT) {
            IllegalArgumentException(Messages.MESSAGE_RACE_COUNT_TOO_SMALL)
        }
    }
}

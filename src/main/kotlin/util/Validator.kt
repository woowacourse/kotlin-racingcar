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

    fun validateCount(count: Int?) {
        require(count != null && count >= Constants.CONDITION_CAR_MIN_COUNT) {
            IllegalArgumentException(Messages.MESSAGE_INVALID_RACE_COUNT)
        }
    }
}
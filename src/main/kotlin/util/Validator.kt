package util

object Validator {
    fun validateCount(count: String) {
        require(count.toIntOrNull() != null) {
            IllegalArgumentException(Messages.MESSAGE_RACE_COUNT_NOT_INTEGER)
        }
    }
}

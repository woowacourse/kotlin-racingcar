package util

object Validator {

    fun validateCarName(input: List<String>) {
        require(input.all { it.isNotEmpty() || it.length <= Constants.CONDITION_CAR_MAX_LENGTH }) {
            IllegalArgumentException()
        }
        require(input.size == input.toSet().size) {
            IllegalArgumentException()
        }
    }

    fun validateCount(count: Int?) {
        require(count != null && count >= Constants.CONDITION_CAR_MIN_COUNT) {
            IllegalArgumentException()
        }
    }
}
object InputValidator {

    fun validateCarName(input: String) {
        require(input.isNotEmpty()) {Constants.ERROR_EMPTY_CAR_NAME_MESSAGE}
        val carNames = input.split(",")
        carNames.forEach {
            validateCarNameLength(it)
        }
        require(validateDuplicatedCarName(carNames)) {Constants.ERROR_DUPLICATED_CAR_NAME_MESSAGE}
    }

    private fun validateCarNameLength(input: String) {
        require(input.length in 1..5) {Constants.ERROR_OUT_OF_BOUND_CAR_NAME_MESSAGE}
    }

    private fun validateDuplicatedCarName(input: List<String>): Boolean {
        return input.distinct().size != input.size
    }

}
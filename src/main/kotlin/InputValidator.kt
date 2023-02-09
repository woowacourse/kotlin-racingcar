object InputValidator {

    fun validateIsNumeric(numberOfTry: String) {
        require(numberOfTry.isNumeric()) {
            NUMERIC_ERROR_MSG
        }
    }

    private fun String.isNumeric(): Boolean {
        return this.chars().allMatch { Character.isDigit(it) }
    }
}

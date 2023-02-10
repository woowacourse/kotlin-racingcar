package domain

object InputValidator {

    fun validateIsNumeric(numberOfTry: String) {
        require(numberOfTry.isNumeric()) {
            InputError.NUMERIC_ERROR.message
        }
    }

    private fun String.isNumeric(): Boolean {
        return this.chars().allMatch { Character.isDigit(it) }
    }
}

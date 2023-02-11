package domain

import data.InputError

object InputValidator {

    private const val TOKENIZER = ","
    private const val EMPTY = ""

    fun validateSuccessiveTokenizer(nameInput: String): List<String> {
        val names = nameInput.split(TOKENIZER)

        names.forEach { name ->
            require(name != EMPTY) {
                InputError.SUCCESSIVE_TOKENIZER_ERROR.message
            }
        }

        return names
    }

    fun validateIsNumeric(numberOfTry: String): Int {
        require(numberOfTry.isNumeric()) {
            InputError.NUMERIC_ERROR.message
        }

        return numberOfTry.toInt()
    }

    private fun String.isNumeric(): Boolean {
        return this.chars().allMatch { Character.isDigit(it) }
    }
}

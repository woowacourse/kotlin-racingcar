package domain

import view.OutputView.EMPTY
import view.OutputView.TOKENIZER

object InputValidator {

    fun validateEmptyInput(nameInput: String): List<String> {
        val names = nameInput.split(TOKENIZER)

        names.forEach { name ->
            require(name != EMPTY) {
                InputError.EMPTY_INPUT_ERROR.message
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

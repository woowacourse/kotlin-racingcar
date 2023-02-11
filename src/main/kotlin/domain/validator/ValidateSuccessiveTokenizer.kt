package domain.validator

import data.InputError

class ValidateSuccessiveTokenizer {

    operator fun invoke(nameInput: String): List<String> {
        val names = nameInput.split(TOKENIZER)

        names.forEach { name ->
            require(name != EMPTY) {
                InputError.SUCCESSIVE_TOKENIZER_ERROR.message
            }
        }

        return names
    }

    companion object {
        private const val TOKENIZER = ","
        private const val EMPTY = ""
    }
}

package domain.validator

class ValidateSuccessiveTokenizer {

    operator fun invoke(nameInput: String): List<String> {
        val names = nameInput.split(TOKENIZER)

        names.forEach { name ->
            require(name != EMPTY) {
                SUCCESSIVE_TOKENIZER_ERROR
            }
        }

        return names
    }

    companion object {
        private const val TOKENIZER = ","
        private const val EMPTY = ""
        private const val SUCCESSIVE_TOKENIZER_ERROR = "[ERROR] 이름 입력시 ,를 연속적으로 입력할 수 없습니다."
    }
}

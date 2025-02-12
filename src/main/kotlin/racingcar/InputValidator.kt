package racingcar

class InputValidator {
    fun carNamesValidate(input: String) {
        emptyCheck(input)
        val names = input.split(",").map { it.trim() }
        nameLengthCheck(names)
        duplicateNameCheck(names)
        availableNameCheck(names)
    }

    fun tryCountValidate(input: String) {
        emptyCheck(input)
        val number = positiveInputCheck(input)
        tryCountLengthCheck(number)
    }

    private fun emptyCheck(input: String) {
        require(input.isNotBlank()) { Messages.ERROR_EMPTY_INPUT.message }
    }

    private fun nameLengthCheck(names: List<String>) {
        names.forEach { name ->
            require(name.length in 1..5) { Messages.ERROR_NAME_LENGTH.message }
        }
    }

    private fun duplicateNameCheck(names: List<String>) {
        require(names.size == names.distinct().size) { Messages.ERROR_DUPLICATE_NAME.message }
    }

    private fun availableNameCheck(names: List<String>) {
        names.forEach { name ->
            val regex = Regex("^[가-힣a-zA-Z0-9]*$")
            require(regex.matches(name)) { Messages.ERROR_NOT_AVAILABLE_NAME.message }
        }
    }

    private fun positiveInputCheck(input: String): Int {
        val number =
            runCatching { input.toInt() }
                .getOrElse { throw IllegalArgumentException(Messages.ERROR_NOT_POSITIVE.message) }
        require(number > 0) { Messages.ERROR_NOT_POSITIVE.message }
        return number
    }

    private fun tryCountLengthCheck(number: Int) {
        require(number.toString().length < 9) { Messages.ERROR_OVERSIZE_TRY_COUNT.message }
    }
}

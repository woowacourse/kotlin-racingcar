package racingcar.global

object InputValidator {
    fun requireCarNames(input: String): String {
        requireEmpty(input)
        val names = input.split(",").map { it.trim() }
        requireDuplication(names)

        names.forEach { name ->
            requireNameLength(name)
            requireAvailableName(name)
        }
        return input
    }

    fun requireRaceCount(input: String): String {
        requireEmpty(input)
        val number = requirePositiveInput(input)
        requireTryCountLength(number)
        return input
    }

    private fun requireEmpty(input: String) {
        require(input.isNotBlank()) { Messages.ERROR_EMPTY_INPUT.message }
    }

    private fun requireNameLength(name: String) {
        require(name.length in 1..5) { Messages.ERROR_NAME_LENGTH.message }
    }

    private fun requireDuplication(names: List<String>) {
        require(names.size == names.distinct().size) { Messages.ERROR_DUPLICATE_NAME.message }
    }

    private fun requireAvailableName(name: String) {
        require(name.all { it.isLetterOrDigit() || it.isWhitespace() }) { Messages.ERROR_NOT_AVAILABLE_NAME.message }
    }

    private fun requirePositiveInput(input: String): Int =
        input.toIntOrNull() ?: throw IllegalArgumentException(Messages.ERROR_NOT_POSITIVE.message)

    private fun requireTryCountLength(number: Int) {
        require(number.toString().length < 9) { Messages.ERROR_OVERSIZE_TRY_COUNT.message }
    }
}

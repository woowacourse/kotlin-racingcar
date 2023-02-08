package racingcar.exceptions

class InputViewExceptions {
    fun validateNames(names: List<String>) {
        require(names.isNotEmpty())
        require(names.all { it.length <= 5 })
    }

    fun validateAttemptCount(input: String) {
        require(input.toIntOrNull() != null)
    }
}

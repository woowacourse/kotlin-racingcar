class InputView {
    private val exceptions = Exceptions()

    fun carNames(): List<String> {
        val input = readln()
        val names = input.split(",")
        exceptions.validateNames(names)
        return names
    }

    fun attemptCount(): Int {
        val input = readln()
        exceptions.validateAttemptCount(input)
        return input.toInt()
    }
}

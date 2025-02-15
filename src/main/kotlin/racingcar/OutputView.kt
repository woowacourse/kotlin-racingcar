package racingcar

class OutputView {
    fun showMessageToUser(
        input: String,
        endWithNewLine: Boolean = false,
    ) = if (endWithNewLine) println(input) else print(input)

    fun showBlankLineToUser() = println()
}

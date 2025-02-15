package racingcar

class OutputView {
    fun printToConsole(
        input: String,
        isWithNewLine: Boolean = false,
    ) = if (isWithNewLine) println(input) else print(input)
}

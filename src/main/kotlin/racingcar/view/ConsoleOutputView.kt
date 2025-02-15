package racingcar.view

import racingcar.OutputView

class ConsoleOutputView : OutputView {
    override val messages: List<String> = listOf()

    override fun showMessage(
        message: String,
        endWithNewLine: Boolean,
    ) = if (endWithNewLine) println(message) else print(message)

    override fun showBlankLine() = println()
}

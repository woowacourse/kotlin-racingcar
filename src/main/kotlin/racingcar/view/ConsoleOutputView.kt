package racingcar.view

import racingcar.OutputView

class ConsoleOutputView : OutputView {
    override fun showMessage(
        message: String,
        endWithNewLine: Boolean,
    ) = if (endWithNewLine) println(message) else print(message)

    override fun showBlankLine() = println()
}

package racingcar.view.input

class ConsoleInputView : InputView {
    override fun askCarNames(): String = readln()

    override fun askNumberOfAttempts(): Int = readln().toInt()
}

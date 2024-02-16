package racingcar.view.input

class ConsoleInputView : InputView {
    override fun askCarNames(): List<String> = readln().split(CAR_NAMES_DELIMITERS)

    override fun askNumberOfAttempts(): Int = readln().toInt()

    companion object {
        private const val CAR_NAMES_DELIMITERS = ","
    }
}

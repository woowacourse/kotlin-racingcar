package racingcar.view.input

interface InputView {
    fun askCarNames(): List<String>

    fun askNumberOfAttempts(): Int
}

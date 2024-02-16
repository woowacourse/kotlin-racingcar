package racingcar.view

class InputView {
    fun askCarNames(): String = readln()

    fun askNumberOfAttempts(): Int = readln().toInt()
}

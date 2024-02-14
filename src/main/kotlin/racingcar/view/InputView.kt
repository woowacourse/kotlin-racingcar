package racingcar.view

class InputView {
    fun askCarNames(): String {
        return readln()
    }

    fun askNumberOfAttempts(): Int {
        return readln().toInt()
    }
}

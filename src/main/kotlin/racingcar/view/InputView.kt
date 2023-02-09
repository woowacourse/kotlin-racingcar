package racingcar.view

import racingcar.exceptions.InputViewExceptions

class InputView {
    fun carNames(): List<String> {
        val input = readln()
        val names = input.split(",")
        InputViewExceptions.validateNames(names)
        return names
    }

    fun attemptCount(): Int {
        val input = readln()
        InputViewExceptions.validateAttemptCount(input)
        return input.toInt()
    }
}

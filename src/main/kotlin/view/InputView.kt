package view

import exception.Validator

class InputView(
    private val validator: Validator
) {
    private val console = System.console()

    fun readCarNames(): List<String> {
        val input = console.readLine()
        return validator.checkCarName(input)
    }

    fun readRoundCount(): Int {
        val input = console.readLine()
        return validator.checkRoundCount(input)
    }
}

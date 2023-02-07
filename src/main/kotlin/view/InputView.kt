package view

import exception.Validator

class InputView(
    private val validator: Validator
) {

    fun readCarNames(): List<String> {
        val console = System.console()
        val input = console.readLine()
        return validator.checkCarName(input)
    }

    fun readRoundCount() {
    }
}

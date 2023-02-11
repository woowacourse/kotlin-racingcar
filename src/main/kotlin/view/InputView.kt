package view

import exception.InputValidator

class InputView(
    private val validator: InputValidator
) {

    fun readCarNames(): List<String> {
        val input = readln()
        return validator.checkCarName(input)
    }

    fun readRoundCount(): Int {
        val input = readln()
        return validator.checkRoundCount(input)
    }
}

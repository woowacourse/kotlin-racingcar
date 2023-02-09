package view

import exception.Validator

class InputView(
    private val validator: Validator
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

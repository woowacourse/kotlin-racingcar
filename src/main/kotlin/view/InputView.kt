package view

import exception.InputValidator

class InputView(
    private val validator: InputValidator
) {

    fun readCarNames(): List<String> {
        val input = readln()
        return input.split(",").map { it.trim() }
    }

    fun readRoundCount(): Int {
        val input = readln()
        return validator.checkRoundCount(input)
    }
}

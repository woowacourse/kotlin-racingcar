package view

import exception.Validator

class InputView(
    private val validator: Validator
) {

    fun readCarNames(): List<String> {
        val input = readlnOrNull() ?: ""
        return input.let { validator.checkCarName(input) }
    }

    fun readRoundCount(): Int {
        val input = readlnOrNull() ?: ""
        return validator.checkRoundCount(input)
    }
}

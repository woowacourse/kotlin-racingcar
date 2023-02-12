package view

import util.Validator

class InputView {
    fun inputCarNames(): String {
        val input = readlnOrNull()
        runCatching {
            Validator().checkNames(input)
        }.onFailure {
            return inputCarNames()
        }.getOrNull()
        return input ?: inputCarNames()
    }

    fun inputTryNumber(): String {
        val input = readlnOrNull()
        runCatching {
            Validator().checkTryNumber(input)
        }.onFailure {
            return inputTryNumber()
        }.getOrNull()
        return input ?: inputTryNumber()
    }
}

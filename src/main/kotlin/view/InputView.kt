package view

import util.Validator

class InputView {
    fun inputCarNames(): String? {
        var input = readlnOrNull()
        runCatching {
            Validator().checkNames(input)
        }.onFailure {
            input = it.message
        }
        return input
    }

    fun inputNumber(): String? {
        var input = readlnOrNull()
        runCatching {
            Validator().checkTryNumber(input)
        }.onFailure {
            input = it.message
        }
        return input
    }
}

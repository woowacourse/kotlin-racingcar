package view

import exception.NameException

class InputView {
    fun inputName(): String? {
        val carNames = readLine()
        NameException(carNames)
        return carNames
    }
}

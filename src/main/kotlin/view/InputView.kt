package view

import exception.NameException
import exception.NullException

class InputView {
    fun inputName(): String {
        val carNames = readLine()
        NullException(carNames)
        NameException(carNames!!)
        return carNames
    }
}

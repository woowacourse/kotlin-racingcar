package view

import exception.NameException
import exception.NullException
import exception.TryCountException

class InputView {
    fun inputName(): String {
        val carNames = readLine()
        NullException(carNames)
        NameException(carNames!!)
        return carNames
    }

    fun inputTryCount(): String {
        val tryCount = readLine()
        NullException(tryCount)
        TryCountException(tryCount!!)
        return tryCount
    }
}

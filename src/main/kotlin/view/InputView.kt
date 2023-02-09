package view

import exception.NameException
import exception.NullException
import exception.TryCountException

class InputView {
    private val nullException = NullException()
    private val nameException = NameException()
    private val tryCountException = TryCountException()

    fun inputName(): String {
        val input = readLine()
        val carNames = nullException.checkNull(input)
        nameException.checkNames(carNames)
        return carNames
    }

    fun inputTryCount(): String {
        val input = readLine()
        val tryCount = nullException.checkNull(input)
        tryCountException.checkTryCount(tryCount)
        return tryCount
    }
}

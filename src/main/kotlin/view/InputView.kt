package view

import validation.NameValidation
import validation.NullValidation
import validation.TryCountValidation

object InputView {

    fun inputName(): String {
        val input = readLine()
        val carNames = NullValidation.checkNull(input)
        NameValidation.checkNames(carNames)
        return carNames
    }

    fun inputTryCount(): String {
        val input = readLine()
        val tryCount = NullValidation.checkNull(input)
        TryCountValidation.checkTryCount(tryCount)
        return tryCount
    }
}

package view

import validation.NameValidation
import validation.NullValidation
import validation.TryCountValidation

class InputView {
    private val nullValidation = NullValidation()
    private val nameValidation = NameValidation()
    private val tryCountValidation = TryCountValidation()

    fun inputName(): String {
        val input = readlnOrNull()
        val carNames = nullValidation.checkNull(input)
        nameValidation.checkNames(carNames)
        return carNames
    }

    fun inputTryCount(): String {
        val input = readlnOrNull()
        val tryCount = nullValidation.checkNull(input)
        tryCountValidation.checkTryCount(tryCount)
        return tryCount
    }
}

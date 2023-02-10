package view

import validation.NameValidation
import validation.NullValidation
import validation.TryCountValidation

class InputView(
    private val nullValidation: NullValidation = NullValidation(),
    private val nameValidation: NameValidation = NameValidation(),
    private val tryCountValidation: TryCountValidation = TryCountValidation()
) {

    fun inputName(): String {
        val input = readLine()
        val carNames = nullValidation.checkNull(input)
        nameValidation.checkNames(carNames)
        return carNames
    }

    fun inputTryCount(): String {
        val input = readLine()
        val tryCount = nullValidation.checkNull(input)
        tryCountValidation.checkTryCount(tryCount)
        return tryCount
    }
}

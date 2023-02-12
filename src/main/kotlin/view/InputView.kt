package view

import validation.NameValidation
import validation.NullValidation
import validation.TryCountValidation

object InputView {

    fun inputName(): String {
        OutputView.printCar()
        val input = readLine()
        val carNames = NullValidation.checkNull(input)
        NameValidation.checkNames(carNames)
        return carNames
    }

    fun inputTryCount(): String {
        OutputView.printTryCount()
        val input = readLine()
        val tryCount = NullValidation.checkNull(input)
        TryCountValidation.checkTryCount(tryCount)
        return tryCount
    }
}

package view

import validation.NameValidation
import validation.TryCountValidation

object InputView {

    fun inputName(): String {
        var input = ""
        var isValidate = false
        while (!isValidate) {
            OutputView.printCar()
            input = readln()
            isValidate = NameValidation.validateCarName(input)
        }
        return input
    }

    fun inputTryCount(): String {
        var input = ""
        var isValidate = false
        while (!isValidate) {
            OutputView.printTryCount()
            input = readln()
            isValidate = TryCountValidation.validateTryCount(input)
        }
        return input
    }
}

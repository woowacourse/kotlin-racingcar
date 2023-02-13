package view

import validation.NameValidation
import validation.NameValidationResult
import validation.TryCountValidation
import validation.TryCountValidationResult

class InputView : InputViewInterface {
    private val nameValidation = NameValidation()
    private val tryCountValidation = TryCountValidation()

    override fun inputName(): NameValidationResult {
        val input = readlnOrNull()
        return nameValidation.checkNames(input)
    }

    override fun inputTryCount(): TryCountValidationResult {
        val input = readlnOrNull()
        return tryCountValidation.checkTryCount(input)
    }
}

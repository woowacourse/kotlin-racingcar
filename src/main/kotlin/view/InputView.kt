package view

import validation.NameValidation
import validation.NameValidationResult
import validation.TryCountValidation
import validation.TryCountValidationResult

class InputView {
    private val nameValidation = NameValidation()
    private val tryCountValidation = TryCountValidation()

    fun inputName(): NameValidationResult {
        val input = readlnOrNull()
        return nameValidation.checkNames(input)
    }

    fun inputTryCount(): TryCountValidationResult {
        val input = readlnOrNull()
        return tryCountValidation.checkTryCount(input)
    }
}

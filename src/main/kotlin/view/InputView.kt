package view

import model.Name
import model.TryCount
import validation.NameValidation
import validation.TryCountValidation
import validation.ValidationResult

class InputView {
    private val nameValidation = NameValidation()
    private val tryCountValidation = TryCountValidation()

    fun inputName(): Name {
        val input = readlnOrNull()
        return when (val result = nameValidation.checkNames(input)) {
            is ValidationResult.Success -> Name(result.input)
            is ValidationResult.Failure -> reInputNameWithError(inputName(), result.errorMessage)
        }
    }

    fun reInputNameWithError(input: Name, errorMessage: String): Name {
        println(errorMessage)
        return input
    }

    fun inputTryCount(): TryCount {
        val input = readlnOrNull()
        return when (val result = tryCountValidation.checkTryCount(input)) {
            is ValidationResult.Success -> return TryCount(result.input)
            is ValidationResult.Failure -> return reInputTryCountWithError(inputTryCount(), result.errorMessage)
        }
    }

    fun reInputTryCountWithError(input: TryCount, errorMessage: String): TryCount {
        println(errorMessage)
        return input
    }
}

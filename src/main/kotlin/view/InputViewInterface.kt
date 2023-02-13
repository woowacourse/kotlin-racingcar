package view

import validation.NameValidationResult
import validation.TryCountValidationResult

interface InputViewInterface {
    fun inputName(): NameValidationResult
    fun inputTryCount(): TryCountValidationResult
}

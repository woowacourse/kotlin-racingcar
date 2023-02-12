package validation

import model.Name

sealed class NameValidationResult {
    data class Success(val name: Name) : NameValidationResult()
    data class Failure(val errorMessage: String) : NameValidationResult()
}

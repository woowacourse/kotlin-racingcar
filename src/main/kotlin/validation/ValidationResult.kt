package validation

sealed class ValidationResult {
    data class Success(val input: String) : ValidationResult()
    data class Failure(val errorMessage: String) : ValidationResult()
}

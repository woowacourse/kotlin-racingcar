package validation

import model.TryCount

sealed class TryCountValidationResult {
    data class Success(val tryCount: TryCount) : TryCountValidationResult()
    data class Failure(val errorMessage: String) : TryCountValidationResult()
}

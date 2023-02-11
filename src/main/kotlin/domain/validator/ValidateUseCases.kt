package domain.validator

data class ValidateUseCases(
    val validateNumberOfTry: ValidateNumberOfTry = ValidateNumberOfTry(),
    val validateSuccessiveTokenizer: ValidateSuccessiveTokenizer = ValidateSuccessiveTokenizer()
)

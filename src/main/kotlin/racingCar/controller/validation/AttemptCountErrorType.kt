package racingCar.controller.validation

enum class AttemptCountErrorType(private val _errorMessage: String) {
    EMPTY_INPUT("경주 횟수에 빈 문자를 입력했습니다."),
    NO_LONG("경주 횟수에는 21억보다 큰 수는 입력하지 못합니다."),
    INTEGER("경주 횟수에는 숫자만 입력이 가능합니다."),
    UP_1("경주 횟수는 1보다 큰 수만 입력이 가능합니다.");

    val errorMessage: String
        get() = ERROR_MESSAGE + _errorMessage

    companion object {
        private const val ERROR_MESSAGE = "[ERROR] "
    }
}
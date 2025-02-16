package racingCar.controller.validation

enum class CarsNameErrorType(private val _errorMessage: String) {
    EMPTY_INPUT("자동차 이름에 빈 문자를 입력했습니다."),
    SAME_NAME("동일한 이름을 입력했습니다."),
    UNDER_5("자동차 이름은 5자 이하만 가능합니다."),
    UP_1("자동차 이름은 쉼표를 기준으로 2대 이상 입력해야합니다.");

    val errorMessage: String
        get() = ERROR_MESSAGE + _errorMessage

    companion object {
        private const val ERROR_MESSAGE = "[ERROR] "
    }
}
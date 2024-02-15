package racingcar.util

enum class InputException(private val message: String) {
    INVALID_CAR_NAME_FORMAT("자동차 이름에 공백이 없어야 한다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름은 1~5자 사이만 가능하다."),
    INVALID_NUMBER_OF_CAR("자동차 이름을 최소 1대 이상 입력해야 한다."),
    INVALID_CAR_NAMES_DUPLICATE("자동차 이름은 중복이 불가능하다."),
    INVALID_NUMBER_OF_ROUND_FORMAT("시도할 횟수는 문자나 공백이 없어야한다."),
    INVALID_NUMBER_OF_ROUND_RANGE("시도할 횟수는 1회 이상의 숫자여야 한다.");

    fun getMessage() = "[ERROR] $message"

}

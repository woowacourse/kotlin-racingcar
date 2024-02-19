package racingcar.util


import racingcar.util.message.ExceptionMessage

enum class Exception(private val message: String) {
    INVALID_CAR_NAME_FORMAT(ExceptionMessage.INVALID_CAR_NAME_FORMAT),
    INVALID_CAR_NAME_LENGTH(ExceptionMessage.INVALID_CAR_NAME_LENGTH),
    INVALID_NUMBER_OF_CAR(ExceptionMessage.INVALID_NUMBER_OF_CAR),
    INVALID_CAR_NAMES_DUPLICATE(ExceptionMessage.INVALID_CAR_NAMES_DUPLICATE),
    INVALID_NUMBER_OF_ROUND_FORMAT(ExceptionMessage.INVALID_NUMBER_OF_ROUND_FORMAT),
    INVALID_NUMBER_OF_ROUND_RANGE(ExceptionMessage.INVALID_NUMBER_OF_ROUND_RANGE);

    fun getMessage() = "[ERROR] $message"
}

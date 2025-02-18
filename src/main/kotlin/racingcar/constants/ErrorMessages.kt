package racingcar.constants

object ErrorMessages {
    private const val ERROR = "[ERROR]"

    const val EMPTY_INPUT_ERROR = "$ERROR 빈 값을 입력하셨습니다."

    const val INVALID_NAME_LENGTH_ERROR = "$ERROR 자동차 이름은 1~5자이어야 합니다."
    const val INVALID_NAME_FORMAT_ERROR = "$ERROR 자동차 이름은 영문 또는 숫자로 이루어져야 합니다."
    const val NOT_UNIQUE_NAME_ERROR = "$ERROR 자동차 이름이 중복됩니다."

    const val NOT_NUMERIC_ERROR = "$ERROR 숫자를 입력해야 합니다."
    const val INVALID_RANGE_ERROR = "$ERROR 1에서 10 사이의 수를 입력해야 합니다."
}

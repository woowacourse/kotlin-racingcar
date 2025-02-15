object Constants {
    const val ERROR = "[ERROR]"
    const val ERROR_EMPTY_CAR_NAME_MESSAGE = "$ERROR 자동차 이름은 공백일 수 없습니다."
    const val ERROR_DUPLICATED_CAR_NAME_MESSAGE = "$ERROR 중복된 자동차 이름이 있습니다."
    const val ERROR_OUT_OF_BOUND_CAR_NAME_MESSAGE = "$ERROR 자동차 이름의 최대 길이를 초과했습니다."
    const val ERROR_EMPTY_TRY_COUNT_MESSAGE = "$ERROR 시도횟수는 공백일 수 없습니다."
    const val ERROR_IS_NOT_NUMBER_MESSAGE = "$ERROR 시도횟수는 숫자여야만 합니다."
    const val ERROR_OUT_OF_BOUND_TRY_COUNT_MESSAGE = "$ERROR 시도횟수는 1에서 1,000 사이의 숫자여야 합니다."

    const val CAR_NAME_LOWER_BOUND = 1
    const val CAR_NAME_UPPER_BOUND = 5
    const val CAR_NAME_DELIMITER = ","
    const val RANDOM_NUMBER_LOWER_BOUND = 0
    const val RANDOM_NUMBER_UPPER_BOUND = 9
    const val MOVING_STANDARD = 4
    const val CAR_POSITION_MARK = "-"
    const val WINNER_NAME_DELIMITER = ", "
    const val TRY_COUNT_LOWER_BOUND = 1
    const val TRY_COUNT_UPPER_BOUND = 1000

    const val INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    const val INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"

    const val OUTPUT_RESULT_MESSAGE = "\n실행 결과"
    const val OUTPUT_FINAL_WINNER_MESSAGE_FORMAT = "최종 우승자: %s"
}

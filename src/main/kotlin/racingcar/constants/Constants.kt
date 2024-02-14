package racingcar.constants

object Constants {
    const val INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    const val INPUT_TRIAL_NUM_MESSAGE = "시도할 횟수는 몇 회인가요?"

    const val INVALID_NAME_SIZE_EXCEPTION = "이름은 1~5글자 사이로 입력해주세요."
    const val DUPLICATED_NAME_EXCEPTION = "서로 중복되지 않는 이름을 입력해주세요."
    const val INVALID_NUM_OF_CARS_EXCEPTION = "2대 이상의 자동차가 필요합니다."
    const val INVALID_TRIAL_NUM_TYPE_EXCEPTION = "숫자를 입력해주세요."
    const val INVALID_TRIAL_NUM_RANGE_EXCEPTION = "1보다 큰 수를 입력해주세요."

    const val TRIAL_RESULT_MESSAGE = "\n실행 결과"
    const val FINAL_WINNERS = "최종 우승자: "
    const val CURRENT_POSITION_TEMPLATE = "%s : %s"
    const val PROGRESS_BAR = "-"
}
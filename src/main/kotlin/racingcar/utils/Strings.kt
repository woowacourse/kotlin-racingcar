package racingcar.utils

// Delimiter
const val CAR_NAME_DELIMITER = ","

// Error
const val CAR_NAME_BOUNDARY_ERROR_MESSAGE = "자동차 이름의 길이는 $MIN_CAR_NAME_LENGTH 이상 $MAX_CAR_NAME_LENGTH 이하로 부탁이요~"
const val DUPLICATED_CAR_NAME_ERROR_MESSAGE = "자동차 이름 중복 빼주세요~"

const val NOT_INTEGER_TYPE_ERROR_MESSAGE = "숫자 형태로 부탁이요~"
const val ROUND_COUNT_BOUNDARY_ERROR_MESSAGE = "라운드 횟수는 $MIN_ROUND_COUNT 이상 $MAX_ROUND_COUNT 이하로 부탁이요~"

// Request Message
const val CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
const val ROUND_COUNT_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?"
const val ROUNDS_RESULT_NOTIFICATION_MESSAGE = "\n실행 결과"
const val WINNER_NOTIFICATION_MESSAGE = "최종 우승자: "
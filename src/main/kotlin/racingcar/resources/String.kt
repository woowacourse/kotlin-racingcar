package racingcar.resources

// FOR OUTPUT VIEW
const val OUTPUT_RESULT = "실행 결과"
const val OUTPUT_WINNER = "최종 우승자: "

// FOR INPUT VIEW
const val INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)"
const val INPUT_COUNT = "시도할 횟수는 몇 회인가요?"

// FOR ERROR MESSAGE
private const val ERROR_MESSAGE_PREFIX = "[ERROR] "
const val ERROR_INPUT_COUNT = ERROR_MESSAGE_PREFIX + "숫자는 0부터 9까지만 입력할 수 있습니다."
const val ERROR_RACING_COUNT_AT_MOST_ONE = ERROR_MESSAGE_PREFIX + "경주 횟수는 1 이상이어야 합니다."
const val ERROR_NAME_LENGTH_RANGE = ERROR_MESSAGE_PREFIX + "자동차 이름은 1~5자 사이어야 합니다."

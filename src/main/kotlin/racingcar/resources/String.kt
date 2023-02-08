package racingcar.resources

// FOR MENU RECOMMEND LOGIC

// FOR OUTPUT VIEW

// FOR INPUT VIEW
const val INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)"

// FOR ERROR MESSAGE
private const val ERROR_MESSAGE_PREFIX = "[ERROR] "
const val ERROR_INPUT_NAME_AT_MOST_FIVE = ERROR_MESSAGE_PREFIX + "자동차 이름은 5자를 초과할 수 없습니다."
const val ERROR_INPUT_COUNT = ERROR_MESSAGE_PREFIX + "숫자는 0부터 9까지만 입력할 수 있습니다."
const val ERROR_RACING_COUNT_AT_MOST_ONE = ERROR_MESSAGE_PREFIX + "경주 횟수는 1 이상이어야 합니다."

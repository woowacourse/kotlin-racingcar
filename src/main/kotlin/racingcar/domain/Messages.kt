package racingcar.domain

enum class Messages(
    val message: String,
) {
    USERINFO_INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    USERINFO_INPUT_RACE_COUNT("시도할 횟수는 몇 회인가요?"),
    RACE_RESULT("실행 결과"),
    WINNER_NAMES_ANNOUNCE("최종 우승자 : %s"),

    ERROR_EMPTY_INPUT("문자열을 입력하지 않으셨습니다."),
    ERROR_NAME_LENGTH("자동차 이름을 1자 이상 5자 이하로 입력하세요."),
    ERROR_DUPLICATE_NAME("중복된 자동차 이름이 존재합니다."),
    ERROR_NOT_AVAILABLE_NAME("지원되지 않는 이름입니다. (한글, 영어, 숫자, 공백 가능)"),
    ERROR_NOT_POSITIVE("1 이상의 양의 정수(자연수)만 입력이 가능합니다."),
    ERROR_OVERSIZE_TRY_COUNT("8자리 이하의 자연수만 입력이 가능합니다."),
    ERROR_MOVE_VALUE("Car의 이동을 결정하는 값은 0~9 이내의 정수만 가능합니다."),
    ;

    fun formattedMessage(vararg args: String) = String.format(message, *args)
}

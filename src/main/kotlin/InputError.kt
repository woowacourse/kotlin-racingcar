enum class InputError(
    val message: String
) {

    NUMERIC_ERROR("[ERROR] 시도 횟수는 숫자 입력으로만 받습니다."),
    EMPTY_INPUT_ERROR("[ERROR] 공백을 입력할수 없습니다."),
    CAR_NAME_ERROR("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.")
}

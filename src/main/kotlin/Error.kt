enum class Error(
    val errorMessage: String
) {

    NUMERIC_ERROR_MSG("[ERROR] 시도 횟수는 숫자 입력으로만 받습니다."),
    CAR_NAME_ERROR_MSG("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.")
}

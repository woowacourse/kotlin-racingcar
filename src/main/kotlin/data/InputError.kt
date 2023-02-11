package data

enum class InputError(
    val message: String
) {

    NUMERIC_ERROR("[ERROR] 시도 횟수는 숫자 입력으로만 받습니다."),
    SUCCESSIVE_TOKENIZER_ERROR("[ERROR] 이름 입력시 ,를 연속적으로 입력할 수 없습니다."),
    CAR_NAME_ERROR("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.")
}

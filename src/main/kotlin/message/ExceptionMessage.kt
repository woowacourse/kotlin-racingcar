package message

class ExceptionMessage {
    companion object {
        const val NAME_IS_ONLY_ENGLISH_AND_NUMBER = "[ERROR] 이름은 영어와 숫자만 가능합니다."
        const val INPUT_IS_EMPTY_ERROR_MESSAGE = "[ERROR] 아무것도 입력하지 않았습니다."
        const val NAME_RANGE_ERROR_MASSAGE = "[ERROR] 자동차 이름은 1자 이상 5자 이하로 입력해주세요"
        const val TRY_COUNT_INTEGER_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자만 입력해 주세요"
        const val TRY_COUNT_POSITIVE_ERROR_MESSAGE = "[ERROR] 시도 횟수는 양의 정수여야 합니다"
    }
}

package racingcar.validator

private const val EMPTY_NAME_ERROR_MESSAGE = "이름을 입력하지 않았습니다. 재입력해주세요."
private const val MAX_NAME_LENGTH_ERROR_MESSAGE = "이름을 5글자 이하로 입력해주세요."
private const val NULL_ERROR_MESSAGE = "널값을 입력할 수 없습니다."
private const val MAX_LENGTH = 5

fun validateCarName(name: String) {
    require(!isEmptyName(name)) { EMPTY_NAME_ERROR_MESSAGE }
    require(!isNull(name)) { NULL_ERROR_MESSAGE }
    require(!isIllegalLength(name)) { MAX_NAME_LENGTH_ERROR_MESSAGE }
}

fun isEmptyName(name: String): Boolean {
    return name.isBlank()
}

fun isIllegalLength(name: String): Boolean {
    return name.length > MAX_LENGTH
}
package racingcar.validator

private const val DUPLICATE_CAR_NAME_EXIST_ERROR_MESSAGE = "중복된 차 이름이 존재합니다."
private const val NULL_ERROR_MESSAGE = "널값을 입력할 수 없습니다."

fun validateCarNames(names: List<String>) {
    require(!isDuplicateNames(names)) { DUPLICATE_CAR_NAME_EXIST_ERROR_MESSAGE }
    require(!isNull(names)) { NULL_ERROR_MESSAGE }
}

private fun isDuplicateNames(names: List<String>): Boolean {
    return HashSet(names).size != names.size
}

fun <T> isNull(input: T): Boolean {
    return input == null
}

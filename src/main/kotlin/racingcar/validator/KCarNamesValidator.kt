package racingcar.validator

private const val DUPLICATE_CAR_NAME_EXIST_ERROR_MESSAGE = "중복된 차 이름이 존재합니다."

fun validateCarNames(names: List<String>) {
    require(!isDuplicateNames(names)) { DUPLICATE_CAR_NAME_EXIST_ERROR_MESSAGE }
}

private fun isDuplicateNames(names: List<String>): Boolean {
    return HashSet(names).size != names.size
}

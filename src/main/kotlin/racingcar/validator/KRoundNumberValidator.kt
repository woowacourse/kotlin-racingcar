package racingcar.validator

private const val INVALID_ROUND_ERROR_MESSAGE = "자연수로 입력해 주세요."
private const val NULL_ERROR_MESSAGE = "널값을 입력할 수 없습니다."
private val POSITIVE_INTEGER_REGEX = Regex("^([1-9][0-9]*)$")

fun validateRoundNumber(round: String) {
    require(!isNull(round)) { NULL_ERROR_MESSAGE }
    require(isPositiveNumber(round)) { INVALID_ROUND_ERROR_MESSAGE }
}

fun isPositiveNumber(round: String): Boolean {
    return round.matches(POSITIVE_INTEGER_REGEX)
}

package racingcar.utils

object InputExceptionUtils {
    private const val MESSAGE_ERROR_CAR_NAME_INPUT = "자동차 이름은 쉼표로 구분하여 올바르게 입력해주세요."
    private const val MESSAGE_ERROR_ROUND_INPUT = "시도 횟수는 1 이상의 숫자로 입력해주세요."

    fun checkCarNames(carNames: String) =
        require(
            carNames.trim().split(",").map {
                it.trim()
            }.all { it.isNotEmpty() and it.isNotBlank() },
        ) { MESSAGE_ERROR_CAR_NAME_INPUT }

    fun checkRoundCnt(round: String) {
        requireNotNull(round.toIntOrNull()) { MESSAGE_ERROR_ROUND_INPUT }
        require(round.toInt() > 0) { MESSAGE_ERROR_ROUND_INPUT }
    }
}

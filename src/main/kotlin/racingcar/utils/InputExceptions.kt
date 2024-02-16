package racingcar.utils

object InputExceptions {
    private const val MESSAGE_ERROR_CAR_NAME_INPUT = "자동차 이름은 5자를 초과할 수 없으며, 쉼표로 구분합니다."
    private const val MESSAGE_ERROR_ROUND_INPUT = "시도 횟수는 자연수로 입력해주세요."

    fun checkCarNames(carNames: String) =
        require(
            carNames.trim().split(",").map {
                it.trim()
            }.all { it.length in 1..5 },
        ) { MESSAGE_ERROR_CAR_NAME_INPUT }

    fun checkRoundCnt(round: String) = requireNotNull(round.toIntOrNull()) { MESSAGE_ERROR_ROUND_INPUT }
}

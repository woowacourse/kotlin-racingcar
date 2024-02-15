package racingcar.utils

object Exceptions {

    const val MESSAGE_ERROR = "잘못입력하셨습니다"

    fun checkCarNames(carNames: String) =
        require(carNames.trim().split(",").all { it.length in 1..5 }) { IllegalArgumentException(MESSAGE_ERROR) }

    fun checkRoundCnt(round: String) = requireNotNull(round.toIntOrNull()) { NumberFormatException(MESSAGE_ERROR) }

}

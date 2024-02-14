package racingcar.utils

object Exceptions {

    const val MESSAGE_ERROR = "잘못입력하셨습니다"

    fun checkCarNames(carNames: String) = require(carNames.split(", ").all { it.length in 1..5 }) { MESSAGE_ERROR }

    fun checkRoundCnt(round: String) = requireNotNull(round.toIntOrNull()) { MESSAGE_ERROR }

}
package racingcar.utils


private const val MESSAGE_ERROR = "잘못입력하셨습니다"

fun List<String>.checkCarNames() = require(this.all { it.length in 1..5 }) { IllegalArgumentException(MESSAGE_ERROR) }

fun String.checkRoundCnt() = requireNotNull(this.toIntOrNull()) { NumberFormatException(MESSAGE_ERROR) }

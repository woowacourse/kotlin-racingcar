package racingcar

import racingcar.util.ErrorMessage

class RoundManager private constructor(
    val time: Int,
) {
    fun play(onRound: () -> Unit) {
        repeat(time) { onRound() }
    }

    companion object {
        fun from(value: String): RoundManager {
            require(value.toIntOrNull() != null && value.toInt() > 0) {
                ErrorMessage.INVALID_ROUND
            }
            return RoundManager(value.toInt())
        }
    }
}

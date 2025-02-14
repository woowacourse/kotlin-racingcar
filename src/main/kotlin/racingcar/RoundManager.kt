package racingcar

import racingcar.util.ErrorMessage

class RoundManager private constructor(
    val roundCount: Int,
) {
    fun play(onEachRound: () -> Unit) {
        repeat(roundCount) { onEachRound() }
    }

    /**
     * create RoundManager from string value.
     * @throws IllegalArgumentException when value is not a number or value isn't greater than 0
     * **/
    companion object {
        fun from(value: String): RoundManager {
            require(value.toIntOrNull() != null && value.toInt() > 0) {
                ErrorMessage.INVALID_ROUND
            }
            return RoundManager(value.toInt())
        }
    }
}

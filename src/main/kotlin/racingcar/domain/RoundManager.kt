package racingcar.domain

import racingcar.util.ErrorMessage

/**
 * @throws IllegalArgumentException when value is not a number or value isn't greater than 0
 * **/
class RoundManager(
    val roundCount: Int,
) {
    init {
        require(roundCount > 0) { ErrorMessage.INVALID_ROUND }
    }

    fun play(onEachRound: () -> Unit) {
        repeat(roundCount) { onEachRound() }
    }
}

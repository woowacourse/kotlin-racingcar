package racingcar.domain

import racingcar.constant.STANDARD_MOVING

class RacingGame {
    fun runGame() {
    }

    fun checkGoingForward(randomNumber: Int): Boolean = randomNumber >= STANDARD_MOVING
}

package racingcar.domain

import racingcar.constant.STANDARD_OF_MOVING

object MovingDiscriminator {
    fun checkGoingForward(randomNumber: Int): Boolean = randomNumber >= STANDARD_OF_MOVING
}

package racingcar.domain

import racingcar.constant.STATE_UNIT

class RacingCar(
    val name: String,
    movingState: Int = 0,
) {
    var movingState: Int = movingState
        private set

    fun moveForward() {
        movingState += 1
    }

    override fun toString(): String = "$name : ${STATE_UNIT.repeat(movingState)}"
}

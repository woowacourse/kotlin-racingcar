package racingcar.domain

import racingcar.constant.STATE_UNIT

class RacingCar(
    private val name: String,
    private var movingState: Int = 0,
) {
    fun moveForward() {
        movingState += 1
    }

    fun getName(): String = this.name
    fun getMovingState(): Int = this.movingState

    fun getStateProgress(): String {
        var value = ""
        for (i in 0 until movingState) {
            value += STATE_UNIT
        }
        return value
    }

    override fun toString(): String = "$name : ${getStateProgress()}"
}

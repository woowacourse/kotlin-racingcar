package racingcar.domain

import racingcar.utils.Constants.MOVE
import racingcar.utils.Constants.MOVE_MAX_RANGE
import racingcar.utils.Constants.MOVE_MIN_RANGE
import racingcar.utils.Constants.STOP

class Car(val carName: String) {
    val position = mutableListOf<String>()

    fun moves(randomNumber: Int) {
        when (randomNumber) {
            in MOVE_MIN_RANGE..MOVE_MAX_RANGE -> position.add(MOVE)
            else -> position.add(STOP)
        }
    }

    fun moveCount(): Int {
        return position.count { it == MOVE }
    }
}

package racingcar.domain

import racingcar.utils.Constants.MOVE
import racingcar.utils.Constants.STOP

class Car(val carName: String) {
    val moveOrStop = mutableListOf<String>()

    fun moves(isMove: Boolean) {
        when (isMove) {
            true -> moveOrStop.add(MOVE)
            false -> moveOrStop.add(STOP)
        }
    }

    fun moveCount(): Int {
        return moveOrStop.count { it == MOVE }
    }
}

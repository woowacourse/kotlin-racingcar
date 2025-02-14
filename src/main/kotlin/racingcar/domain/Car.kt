package racingcar.domain

import racingcar.utils.Constants.MOVE
import racingcar.utils.Constants.STOP

class Car(val carName: String) {
    val position = mutableListOf<String>()

    fun moves(isMove: Boolean) {
        when (isMove) {
            true -> position.add(MOVE)
            false -> position.add(STOP)
        }
    }

    fun moveCount(): Int {
        return position.count { it == MOVE }
    }
}

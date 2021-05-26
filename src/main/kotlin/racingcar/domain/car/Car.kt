package racingcar.domain.car

import racingcar.domain.Name
import racingcar.domain.Position
import racingcar.domain.STARTING_POSITION

private const val CONDITION_TO_MOVE = 4;

class Car(val name: Name) {

    private var position = STARTING_POSITION

    fun tryToMove(num: Int) {
        if (num >= CONDITION_TO_MOVE) {
            position = position.moveForward()
        }
    }

    fun isIn(position: Position): Boolean {
        return this.position == position
    }

    fun position(): Int {
        return position.value
    }
}
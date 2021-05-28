package racingcar.domain.car

import racingcar.domain.Name
import racingcar.domain.Position

private const val CONDITION_TO_MOVE = 4;

class Car(val name: Name, private val position: Position = Position.STARTING_POSITION) {

    fun tryToMove(num: Int): Car {
        if (num >= CONDITION_TO_MOVE) {
            return Car(name, position.moveForward())
        }
        return Car(name, position)
    }

    fun isIn(position: Position): Boolean {
        return this.position == position
    }

    fun position(): Int {
        return position.value
    }
}
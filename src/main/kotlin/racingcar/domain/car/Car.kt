package racingcar.domain.car

import racingcar.domain.Name
import racingcar.domain.Position
import racingcar.domain.STARTING_POSITION

const val CONDITION_TO_MOVE = 4;

class Car(name: Name) {
    private val name = name
    private var position = STARTING_POSITION

    fun tryToMove(num: Int) {
        if (num >= CONDITION_TO_MOVE) {
            position = position.moveForward()
        }
    }

    fun isIn(position: Position): Boolean {
        return this.position == position
    }

    fun name(): String {
        return name.value()
    }

    fun position(): Int {
        return position.value()
    }
}
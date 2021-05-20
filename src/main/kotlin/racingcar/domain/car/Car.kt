package racingcar.domain.car

import racingcar.domain.Name
import racingcar.domain.Position

const val MINIMUM_TO_MOVE = 4;

class Car(name: Name) {
    private val name: Name = name
    private var position: Position = Position(0)

    fun tryToMove(num: Int) {
        if (num >= MINIMUM_TO_MOVE) {
            position = position.moveForward()
        }
    }

    fun isIn(position: Position): Boolean {
        return this.position == position
    }

    fun name(): String {
        return name.name()
    }

    fun position(): Int {
        return position.value()
    }
}
package racingcar.domain.car

import racingcar.domain.Name

const val MINIMUM_TO_MOVE = 4;

class Car(name: Name) {
    private val name: Name = name
    private var position: Int = 0

    fun tryToMove(num: Int) {
        if (num >= MINIMUM_TO_MOVE) {
            position++
        }
    }

    fun isIn(position: Int): Boolean {
        return this.position == position;
    }

    fun name(): String {
        return name.name()
    }

    fun position(): Int {
        return position
    }
}
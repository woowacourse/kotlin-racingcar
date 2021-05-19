package racingcar.domain.car

import racingcar.domain.name.Name

class Car(name: Name) {
    private val name: Name = name
    private var position: Int = 0

    fun tryToMove(num: Int) {
        if (num >= 4) {
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
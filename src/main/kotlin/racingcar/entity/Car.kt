package racingcar.entity

import racingcar.misc.Values

class Car(private var name: Name) {
    private var position = Position(0)

    fun forward(number: Int) {
        if (number >= Values.WIN_NUMBER)
            position.addPosition(1)
    }

    fun compareTo(car: Car): Boolean {
        return position.compareTo(car.position)
    }

    override fun toString() = "$name : $position"

    override fun equals(other: Any?) = this.position == (other as Car).position && this.name == other.name

    fun getName() = name
}

package racingcar.domain

class Car(
    val name: Name
) {
    var position: Position = Position()
        private set

    fun move(number: Int) {
        if (number >= 4) {
            position = position.increase()
        }
    }

    fun isSamePosition(other: Position): Boolean {
        return position == other
    }

    companion object {
        fun from(name: String): Car {
            return Car(Name(name))
        }
    }
}

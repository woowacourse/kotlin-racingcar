package racingcar.domain

class Car(
    val name: Name
) {
    var position: Int = 0
        private set

    fun move(number: Int) {
        if (number >= 4) {
            position++
        }
    }

    fun isSamePosition(otherPosition: Int): Boolean {
        return position == otherPosition
    }

    companion object {
        fun from(name: String): Car {
            return Car(Name(name))
        }
    }
}

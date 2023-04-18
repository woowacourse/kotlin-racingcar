package racingcar.domain

class Car(private val name: String, val position: Int) {
    init {
        require(name.length <= 5) { "이름은 5자 이하만 가능합니다" }
    }

    constructor(name: String) : this(name, 0)

    fun move(number: Int): Car {
        if (number > 4) {
            return Car(name, position + 1)
        }
        return this
    }

    fun isSamePosition(otherPosition: Int): Boolean {
        return position == otherPosition
    }
}

package racingcar.domain

class Car(val name: String, var position: Int) {
    init {
        require(name.length <= 5) { "이름은 5자 이하만 가능합니다" }
    }

    constructor(name: String) : this(name, 0)

    fun move(number: Int) {
        if (number >= 4) {
            position++
        }
    }

    fun isSamePosition(otherPosition: Int): Boolean {
        return position == otherPosition
    }
}

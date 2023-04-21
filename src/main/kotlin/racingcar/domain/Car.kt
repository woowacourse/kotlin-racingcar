package racingcar.domain

class Car(
    val name: String
) {
    var position: Int = 0
        private set

    init {
        require(name.length <= 5) { "이름은 5자 이하만 가능합니다" }
    }

    fun move(number: Int) {
        if (number >= 4) {
            position++
        }
    }

    fun isSamePosition(otherPosition: Int): Boolean {
        return position == otherPosition
    }
}

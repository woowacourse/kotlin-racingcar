package racingcar.entity

data class Car(val name: Name) {
    private var position = Position(0)

    fun forward(number: Int) {
        if (number >= WIN_NUMBER)
            position.addPosition(1)
    }

    fun compareTo(car: Car): Boolean {
        return position.compareTo(car.position)
    }

    override fun toString() = "$name : $position"

    companion object {
        const val WIN_NUMBER = 4
    }
}

package racingcar.entity

data class Car(val name: Name) {
    val position = Position(DEFAULT_POSITION)

    fun forward(number: Int) {
        if (number >= WIN_NUMBER)
            position.addPosition(FORWARD_LENGTH)
    }

    fun compareByPosition(car: Car): Boolean {
        return position.compareTo(car.position)
    }

    companion object {
        const val WIN_NUMBER = 4
        const val DEFAULT_POSITION = 0
        const val FORWARD_LENGTH = 1
    }
}

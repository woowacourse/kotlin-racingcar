package racingcar.entity

class Car(private var name: Name) {
    private var position = Position(0)

    fun forward() {
        position.addPosition(1)
    }

    fun compareTo(car: Car): Boolean {
        return position.compareTo(car.position)
    }

    override fun toString(): String {
        return "$name : $position"
    }

    fun getName() = name
}

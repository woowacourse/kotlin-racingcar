package racingcar.entity

class Car(private var name: Name) {
    private var position = Position(0)

    fun forward() {
        position.addPosition(1)
    }

    fun compareTo(car: Car): Boolean {
        return position.compareTo(car.position)
    }

    override fun toString() = "$name : $position"

    override fun equals(other: Any?) = this.position == (other as Car).position && this.name == other.name

    fun getName() = name
}

package racingcar.entity

class Car(val name: Name, var position: Position = Position(0)) {
    fun forward() {
        position.addPosition(1)
    }

    fun compareTo(car: Car): Boolean {
        return position.compareTo(car.position)
    }

    override fun toString() = name.toString()

    override fun equals(other: Any?) = this.position == (other as Car).position && this.name == other.name
}

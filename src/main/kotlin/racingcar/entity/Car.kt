package racingcar.entity

data class Car(val name: Name, var position: Position = Position(0)) {
    fun forward() {
        position.addPosition(1)
    }

    fun compareTo(car: Car): Boolean {
        return position.compareTo(car.position)
    }
}

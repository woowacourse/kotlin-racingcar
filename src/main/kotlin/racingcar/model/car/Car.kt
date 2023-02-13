package racingcar.model.car

class Car(name: String, private var _position: Int = 0) {
    val carName: CarName = CarName(name)
    val position: Int get() = _position

    fun moveRandomly(moveCondition: Int) {
        if (moveCondition >= MOVEMENT_PROBABILITY) {
            ++_position
        }
    }

    fun toDto(): CarDto = CarDto(carName.name)

    companion object {
        private const val MOVEMENT_PROBABILITY = 4
    }
}

class CarDto(_carName: String, val position: Int = 0) {
    val carName: CarName = CarName(_carName.trim())

    fun toModel(): Car = Car(carName.name, position)
}

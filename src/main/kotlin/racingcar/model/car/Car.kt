package racingcar.model.car

open class Car(name: String, _position: Int = 0) {
    var carName: CarName = CarName(name)
        private set
    var position: Int = _position
        private set

    fun moveRandomly(moveCondition: Int) {
        if (moveCondition >= MOVEMENT_PROBABILITY) {
            ++position
        }
    }

    fun toDto(): CarDto = CarDto(carName.name)

    companion object {
        private const val MOVEMENT_PROBABILITY = 4
    }
}

class CarDto(_carName: String, val position: Int = 0) {
    var carName: CarName = CarName(_carName.trim())
        private set

    fun toModel(): Car = Car(carName.name, position)
}

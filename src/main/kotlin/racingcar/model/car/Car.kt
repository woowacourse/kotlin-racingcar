package racingcar.model.car

open class Car(name: String, _position: Int = 0) {
    var carName: CarName = CarName(name)
        private set
    var position: Int = _position
        private set

    fun moveRandomly() {
        if (generateRandomProbability() >= MOVEMENT_PROBABILITY) {
            ++position
        }
    }

    open fun generateRandomProbability(): Int =
        (START_RANDOM_MOVEMENT_PROBABILITY..END_RANDOM_MOVEMENT_PROBABILITY).random()

    fun toDto(): CarDto = CarDto(carName.name)

    companion object {
        private const val MOVEMENT_PROBABILITY = 4
        private const val START_RANDOM_MOVEMENT_PROBABILITY = 1
        private const val END_RANDOM_MOVEMENT_PROBABILITY = 10
    }
}

class CarDto(_carName: String, val position: Int = 0) {
    var carName: CarName = CarName(_carName)
        private set

    fun toModel(): Car = Car(carName.name, position)
}

package racingcar.model.car

class Car(name: String, private var _position: Int = 0) {
    val carName: CarName = CarName(name)
    val position: Int get() = _position

    fun moveRandomly(moveCondition: Int) {
        if (moveCondition >= MOVEMENT_PROBABILITY) {
            ++_position
        }
    }

    companion object {
        private const val MOVEMENT_PROBABILITY = 4
    }
}

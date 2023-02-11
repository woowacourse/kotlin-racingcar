package racingcar.model.car

class Car(name: String) {
    var carName: CarName = CarName(name)
        private set
    var position: Int = 0
        private set

    fun move(condition: Int) {
        if (condition >= MOVEMENT_PROBABILITY) {
            ++position
        }
    }

    companion object {
        private const val MOVEMENT_PROBABILITY = 4
    }
}

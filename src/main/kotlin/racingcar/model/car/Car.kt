package racingcar.model.car

open class Car(name: String) {
    var carName: CarName = CarName(name)
        private set
    var position: Int = 0
        private set

    fun moveRandomly() {
        if (generateRandomProbability() >= MOVEMENT_PROBABILITY) {
            ++position
        }
    }

    open fun generateRandomProbability(): Int =
        (START_RANDOM_MOVEMENT_PROBABILITY..END_RANDOM_MOVEMENT_PROBABILITY).random()

    companion object {
        private const val MOVEMENT_PROBABILITY = 4
        private const val START_RANDOM_MOVEMENT_PROBABILITY = 1
        private const val END_RANDOM_MOVEMENT_PROBABILITY = 10
    }
}

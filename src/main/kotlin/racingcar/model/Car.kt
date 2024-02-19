package racingcar.model

class Car(val name: String) {
    var position: Int = DEFAULT_POSITION
        private set

    fun moveCar() {
        position += 1
    }

    companion object {
        const val DEFAULT_POSITION = 0
    }
}

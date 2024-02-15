package racingcar.model

class Car(
    private val name: String,
    private var step: Int = 0
) {
    fun moveCar() {
        step += 1
    }
}

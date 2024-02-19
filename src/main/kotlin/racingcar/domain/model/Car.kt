package racingcar.domain.model

class Car(
    private val name: String
) {
    private var step: Int = 0

    fun moveCar() {
        step += 1
    }

    fun getName(): String = name

    fun getStep(): Int = step
}

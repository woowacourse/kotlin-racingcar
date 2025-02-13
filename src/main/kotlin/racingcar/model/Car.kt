package racingcar.model

class Car(
    private val name: String,
    private var position: Int = 0,
) {
    fun move() {
        position++
    }
}

package racing.model

class Car(private val name: String) {
    private var position = 0

    fun getPosition() = position

    fun move() {
        position++
    }
}

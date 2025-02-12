import kotlin.random.Random

class Car(val name: String) {
    private var _position = 0
    val position get() = _position

    fun move() {
        if (Random.nextInt(10) >= 4) _position++
    }
}
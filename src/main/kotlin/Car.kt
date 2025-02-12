import kotlin.random.Random

class Car(val name: String) {
    private var _position = INIT_POSITION
    val position get() = _position

    fun move() {
        if (Random.nextInt(TRY_NUMBER_UNTIL) >= MOVE_MIN_NUMBER) _position++
    }
}

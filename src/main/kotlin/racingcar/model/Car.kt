package racingcar.model

data class Car(
    val name: String,
    private var _position: Int = 0
) {
    val position: Int
        get() = _position

    fun move() {
        _position++
    }
}

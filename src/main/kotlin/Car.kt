data class Car(val name: String) {
    init {
        require(name.length < CAR_NAME_LENGTH) { CAR_NAME_ERROR }
    }

    private var _position = INIT_POSITION
    val position get() = _position

    fun move(numberGenerator: NumberGenerator) {
        if (numberGenerator.generate() >= MOVE_MIN_NUMBER) _position++
    }
}

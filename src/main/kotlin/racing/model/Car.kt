package racing.model

class Car(private val name: String) {
    private var position = 0

    fun getPosition() = position

    fun getName() = name

    fun move(randomNumber: Int) {
        if (checkMove(randomNumber)) position++
    }

    private fun checkMove(randomNumber: Int) = randomNumber >= CAN_MOVE_MINIMUM

    companion object {
        private const val CAN_MOVE_MINIMUM = 4
    }
}

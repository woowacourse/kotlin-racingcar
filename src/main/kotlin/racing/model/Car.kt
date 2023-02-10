package racing.model

class Car(private val name: String) {
    private var position = 0

    fun getPosition() = position

    fun getName() = name

    fun move(conditionNumber: Int) {
        if (checkMove(conditionNumber)) position++
    }

    private fun checkMove(randomNumber: Int) = randomNumber >= CAN_MOVE_MINIMUM

    companion object {
        private const val CAN_MOVE_MINIMUM = 4
    }
}

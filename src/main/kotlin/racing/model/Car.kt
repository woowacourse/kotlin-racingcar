package racing.model

class Car(val name: String) {
    var position = 0
        private set

    fun move(randomNumber: Int) {
        if (checkMove(randomNumber)) position++
    }

    private fun checkMove(randomNumber: Int) = randomNumber >= CAN_MOVE_MINIMUM

    companion object {
        private const val CAN_MOVE_MINIMUM = 4
    }
}

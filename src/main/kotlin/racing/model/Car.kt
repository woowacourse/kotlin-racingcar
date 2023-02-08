package racing.model

import racing.util.NumberGenerator

class Car(private val name: String) {
    private var position = 0
    private val numberGenerator = NumberGenerator()
    fun getPosition() = position

    fun move() {
        position++
    }

    fun checkMove(randomNumber: Int) = randomNumber >= CAN_MOVE_MINIMUM

    companion object {
        private const val CAN_MOVE_MINIMUM = 4
    }
}

package racing.model

import racing.util.NumberGenerator

class Car(private val name: String) {
    private var position = 0

    fun getPosition() = position

    fun getName() = name

    fun move() {
        val randomNumber = numberGenerator.generate()
        if (checkMove(randomNumber)) position++
    }

    private fun checkMove(randomNumber: Int) = randomNumber >= CAN_MOVE_MINIMUM

    companion object {
        private val numberGenerator = NumberGenerator()
        private const val CAN_MOVE_MINIMUM = 4
    }
}
